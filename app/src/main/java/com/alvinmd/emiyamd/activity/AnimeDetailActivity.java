package com.alvinmd.emiyamd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvinmd.emiyamd.R;
import com.alvinmd.emiyamd.model.Result;
import com.bumptech.glide.Glide;

public class AnimeDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ANIME = "extra_data";
    TextView tvTitle, tvDescription;
    ImageView ivThumb;
    String title,description,image;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);

        tvTitle = findViewById(R.id.tvTitleAnimeDetail);
        tvDescription = findViewById(R.id.tvDescriptionAnimeDetail);
        ivThumb = findViewById(R.id.ivAnimeDetail);

        result = getIntent().getParcelableExtra(EXTRA_ANIME);
        title = result.getAnimeTitle();
        description = result.getAnimeDescription();
        image = result.getAnimeImages();

        Glide.with(getApplicationContext())
                .load(image)
                .into(ivThumb);
        tvTitle.setText(title);
        tvDescription.setText(description);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}