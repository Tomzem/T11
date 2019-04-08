package com.tomze.tiu.ui.activity;

import android.content.Intent;

import com.tomze.tiu.R;
import com.tomze.tiu.app.ConfigManager;
import com.tomze.tiu.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Tomze
 * @time 2019.04.03
 * @desc 首页跳转页面
 */
public class SplashActivity extends BaseActivity {

    private int JUMP_TIME = ConfigManager.DEFAULT_JUMP_TIME;
    private Timer timer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    /**
     * 几秒后跳转
     */
    private void jump() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                JUMP_TIME--;
                if (JUMP_TIME == 0) {
                    jump2Activity();
                }
            }
        }, 1000, 1000);
    }

    private void jump2Activity() {
        Intent toMain = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(toMain);
        finish();
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (JUMP_TIME <= 0) {
            jump2Activity();
        } else {
            jump();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (timer != null) {
            timer.cancel();
        }
    }
}
