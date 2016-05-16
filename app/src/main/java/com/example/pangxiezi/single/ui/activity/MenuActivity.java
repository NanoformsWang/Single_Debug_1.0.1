package com.example.pangxiezi.single.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pangxiezi.single.R;
import com.example.pangxiezi.single.ui.adapter.DateAdapter;
import com.example.pangxiezi.single.ui.adapter.MenuAdapter;
import com.example.pangxiezi.single.ui.widget.GestureListener;
import com.example.pangxiezi.single.ui.widget.MyItemAnimator;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends BaseActivity implements View.OnClickListener, MenuAdapter.OnChildClickListener {


    @Bind(R.id.menu_exit_ibtn)
    ImageButton menuExitIbtn;
    @Bind(R.id.menu_setting_ibtn)
    ImageButton menuSettingIbtn;
    @Bind(R.id.menu_recycler)
    RecyclerView menuRecycler;
    @Bind(R.id.menu_layout)
    LinearLayout menuLayout;

    private List<String> menuDatas;
    private MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        initData();
        initEvent();
    }

    private void initData() {
        menuRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        menuDatas = Arrays.asList(getResources().getStringArray(R.array.menu));
        adapter = new MenuAdapter(menuDatas, this);
        menuRecycler.setAdapter(adapter);
    }

    private void initEvent() {
        menuExitIbtn.setOnClickListener(this);
        menuSettingIbtn.setOnClickListener(this);
        adapter.setOnChildClickListener(this);
        MyItemAnimator animator = new MyItemAnimator();
        animator.setRemoveDuration(1000);
        animator.setAddDuration(1000);
        menuRecycler.setItemAnimator(animator);
        menuLayout.setLongClickable(true);
        menuLayout.setOnTouchListener(new MenuGestureListener(this));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_exit_ibtn:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.menu_setting_ibtn:
                startActivity(new Intent(this, SettingActivity.class));
                break;
        }
    }

    @Override
    public void onChildClick(View child, int position, String menuName) {
        switch (menuName) {
            case "首页":
//                Toast.makeText(this, menuName, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case "文字":
//                Toast.makeText(this, menuName, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ArticleActivity.class));
                break;
            case "声音":
//                Toast.makeText(this, menuName, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MusicActivity.class));
                break;
            case "影像":
//                Toast.makeText(this, menuName, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, VideoActivity.class));
                break;
            case "单向历":
//                Toast.makeText(this, menuName, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, DateActivity.class));
                break;
            case "搜索":
                Toast.makeText(this, menuName, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public class MenuGestureListener extends GestureListener {

        public MenuGestureListener(Context context) {
            super(context);
        }

        @Override
        public boolean left() {
            startActivity(new Intent(MenuActivity.this, MainActivity.class));
            overridePendingTransition(R.anim.in_from_right, R.anim.out_from_left);
            return super.right();
        }
    }
}
