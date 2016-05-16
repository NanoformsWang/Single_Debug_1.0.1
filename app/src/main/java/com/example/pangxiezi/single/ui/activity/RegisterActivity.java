package com.example.pangxiezi.single.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pangxiezi.single.R;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.register_back_btn)
    ImageButton registerBackBtn;
    @Bind(R.id.regist_phone_edit)
    EditText registPhoneEdit;
    @Bind(R.id.regist_get_code_btn)
    Button registGetCodeBtn;
    @Bind(R.id.register_into_code_edit)
    EditText registerIntoCodeEdit;
    @Bind(R.id.register_btn)
    Button registerBtn;

    private EventHandler eh;
    private RegisterPage registerPage = new RegisterPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

//        SMSSDK.initSDK(this, "10a126d83db00", "bc57385111a736369a3b9a8dc4b4593f");
        initEvent();
//        initGetSMSCode();

    }

    private void initEvent() {
        registerBackBtn.setOnClickListener(this);
        registPhoneEdit.setOnClickListener(this);
        registGetCodeBtn.setOnClickListener(this);
        registerIntoCodeEdit.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
    }

//    private void initGetSMSCode() {
//        //打开注册页面
//        RegisterPage registerPage = new RegisterPage();
//        eh = new EventHandler() {
//            @Override
//            public void afterEvent(int event, int result, Object data) {
//
//                if (result == SMSSDK.RESULT_COMPLETE) {
//                    //回调完成
//                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
//                        //提交验证码成功
//                        System.out.println("成功！");
//                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
//                        //获取验证码成功
//                        System.out.println("获取验证码成功");
//                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
//                        //返回支持发送验证码的国家列表
//                    }
//                } else {
//                    ((Throwable) data).printStackTrace();
//                }
//            }
//        };
//        registerPage.setRegisterCallback(eh);
//        SMSSDK.registerEventHandler(eh);
//    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_back_btn:
                finish();
                break;
            case R.id.regist_get_code_btn:

                initRegister();
                Toast.makeText(this, registPhoneEdit.getText().toString(), Toast.LENGTH_SHORT).show();
                if (!TextUtils.isEmpty(registPhoneEdit.getText().toString())) {
                    SMSSDK.getVerificationCode("86", registPhoneEdit.getText()
                            .toString());
                    }
                 break;
            case R.id.register_btn:
                //把短信里的验证码提交到服务器
                SMSSDK.submitVerificationCode("86", registerIntoCodeEdit.getText().toString(), registerIntoCodeEdit.getText().toString());
                break;
    }

}

    private void initRegister() {
        registerPage.setRegisterCallback(eh = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                }
            }
        });
        registerPage.show(RegisterActivity.this);
    }


    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ButterKnife.unbind(this);
        SMSSDK.unregisterEventHandler(eh);
    }
}
