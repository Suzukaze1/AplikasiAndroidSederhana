package com.alvinmd.emiyamd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {

    RelativeLayout relativeLayoutWelcome;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        relativeLayoutWelcome = findViewById(R.id.rrWelcomeSplash);

        thread.start();
        handler.postDelayed(runnable, 2000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relativeLayoutWelcome.setVisibility(View.VISIBLE);
        }
    };

    Thread thread = new Thread(){
        public void run(){
            try {
                sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }
    };
}