package com.alvinmd.emiyamd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {

    RelativeLayout relativeLayoutWelcome,relativeLayoutWelcome2;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        relativeLayoutWelcome = findViewById(R.id.rrWelcomeSplash);
        relativeLayoutWelcome2 = findViewById(R.id.rrWelcomeSplash2);

        thread.start();
        handler.postDelayed(runnable, 2000);
        handler.postDelayed(runnable1, 3000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relativeLayoutWelcome.setVisibility(View.VISIBLE);
        }
    };

    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            relativeLayoutWelcome2.setVisibility(View.VISIBLE);
        }
    };

    Thread thread = new Thread(){
        public void run(){
            try {
                sleep(6000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }
    };
}