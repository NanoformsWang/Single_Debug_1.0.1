package com.example.pangxiezi.single.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pangxiezi.single.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.login_back_btn)
    ImageButton loginBackBtn;
    @Bind(R.id.login_back_register)
    TextView loginBackRegister;
    @Bind(R.id.login_phone_edit)
    EditText loginPhoneEdit;
    @Bind(R.id.login_password_edit)
    EditText loginPasswordEdit;
    @Bind(R.id.login_btn)
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initEvent();

    }

    private void initEvent() {
        loginBackBtn.setOnClickListener(this);
        loginBackRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_back_btn:
                finish();
                break;
            case R.id.login_back_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }

    }
}
