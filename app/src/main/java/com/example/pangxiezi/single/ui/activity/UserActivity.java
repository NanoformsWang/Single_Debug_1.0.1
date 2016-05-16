package com.example.pangxiezi.single.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.ui.adapter.UserAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class UserActivity extends BaseActivity implements View.OnClickListener, UserAdapter.OnChildClickListener {

    @Bind(R.id.user_exit_ibtn)
    ImageButton userExitIbtn;
    @Bind(R.id.user_setting_ibtn)
    ImageButton userSettingIbtn;
    @Bind(R.id.user_login_btn)
    Button userLoginBtn;
    @Bind(R.id.user_recycler)
    RecyclerView userRecycler;
    @Bind(R.id.user_layout)
    LinearLayout userLayout;

    private List<String> userDatas;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        initData();
        initEvent();
    }

    private void initData() {
        userRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        userDatas = Arrays.asList(getResources().getStringArray(R.array.user));
        adapter = new UserAdapter(userDatas, this);
        userRecycler.setAdapter(adapter);
    }

    private void initEvent() {
        userExitIbtn.setOnClickListener(this);
        userSettingIbtn.setOnClickListener(this);
        userLoginBtn.setOnClickListener(this);
        adapter.setOnChildClickListener(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_exit_ibtn:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.user_setting_ibtn:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.user_login_btn:
                Toast.makeText(this, "请登录......", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onChildCliCK(View child, int position, String userItem) {
        switch (userItem) {
            case "消息":
//                Toast.makeText(this, userItem, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case "收藏":
//                Toast.makeText(this, userItem, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case "评论":
//                Toast.makeText(this, userItem, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case "离线":
                Toast.makeText(this, userItem, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
