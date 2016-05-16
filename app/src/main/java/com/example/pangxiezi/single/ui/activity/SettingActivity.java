package com.example.pangxiezi.single.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pangxiezi.single.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SettingActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {

    @Bind(R.id.back_btn)
    ImageButton backBtn;
    @Bind(R.id.sel_message_btn)
    ImageButton selMessageBtn;
    @Bind(R.id.clear_cache_text)
    TextView clearCacheText;
    @Bind(R.id.rl_cache_btn)
    RelativeLayout rlCacheBtn;
    @Bind(R.id.sel_font_text)
    TextView selFontText;
    @Bind(R.id.rl_font_btn)
    RelativeLayout rlFontBtn;
    @Bind(R.id.sel_traffic_btn)
    ImageButton selTrafficBtn;
    @Bind(R.id.rl_about_btn)
    RelativeLayout rlAboutBtn;
    @Bind(R.id.rl_suggestion_btn)
    RelativeLayout rlSuggestionBtn;
    @Bind(R.id.rl_version_number_btn)
    RelativeLayout rlVersionNumberBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        initEvent();
    }

    private void initEvent() {
//        rlVersionNumberBtn.setOnTouchListener(this);
//        rlSuggestionBtn.setOnTouchListener(this);
//        rlAboutBtn.setOnTouchListener(this);
        rlVersionNumberBtn.setOnClickListener(this);
        rlSuggestionBtn.setOnClickListener(this);
        rlAboutBtn.setOnClickListener(this);
        selTrafficBtn.setOnClickListener(this);
//        rlFontBtn.setOnTouchListener(this);
//        rlCacheBtn.setOnTouchListener(this);
        rlFontBtn.setOnClickListener(this);
        rlCacheBtn.setOnClickListener(this);
        selMessageBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn:
                finish();
                break;
            case R.id.rl_version_number_btn:
                Toast.makeText(this, "已是最新版本", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_suggestion_btn:
                startActivity(new Intent(this, SuggestionActivity.class));
                break;
            case R.id.rl_about_btn:
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case R.id.sel_traffic_btn:
                Toast.makeText(this, "离线缓存", Toast.LENGTH_LONG).show();
                break;
            case R.id.rl_font_btn:
                startActivity(new Intent(this, FontActivity.class));
                selFontText.setText("大号");
                break;
            case R.id.rl_cache_btn:

                clearCacheText.setText("0B");
                break;
            case R.id.sel_message_btn:
                Toast.makeText(this, "消息推送", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return true;
    }
}
