package com.example.pangxiezi.single.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pangxiezi.single.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SuggestionActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    @Bind(R.id.suggestion_back_btn)
    ImageButton suggestionBackBtn;
    @Bind(R.id.suggestion_content_txt)
    TextView suggestionContentTxt;
    @Bind(R.id.suggestion_edit_txt)
    EditText suggestionEditTxt;
    @Bind(R.id.suggestion_send_btn)
    Button suggestionSendBtn;

    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        ButterKnife.bind(this);

        suggestionBackBtn.setOnClickListener(this);
        suggestionEditTxt.addTextChangedListener(this);
        suggestionSendBtn.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.suggestion_back_btn:
                finish();
                break;
            case R.id.suggestion_send_btn:
                suggestionContentTxt.setText(content);
                suggestionEditTxt.clearComposingText();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        content = s + "";
    }
}
