package com.alvinmd.emiyamd.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.alvinmd.emiyamd.R;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rrAnimeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        rrAnimeList = findViewById(R.id.rrAnimeList);
        rrAnimeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AnimeListActivity.class);
                startActivity(i);
            }
        });
    }
}