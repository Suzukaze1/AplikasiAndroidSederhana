package com.alvinmd.emiyamd.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alvinmd.emiyamd.R;
import com.alvinmd.emiyamd.adapter.RVAnime;
import com.alvinmd.emiyamd.model.ResponseAnime;
import com.alvinmd.emiyamd.model.Result;
import com.alvinmd.emiyamd.rest.ApiAnimeRead;
import com.alvinmd.emiyamd.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeListActivity extends AppCompatActivity {

    private RVAnime adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_list);

        recyclerView = findViewById(R.id.rvAnimeList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        calls();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void calls() {
        ApiInterface apiInterface = ApiAnimeRead.getClient().create(ApiInterface.class);
        Call<ResponseAnime>call = apiInterface.getAnime();
        call.enqueue(new Callback<ResponseAnime>() {
            @Override
            public void onResponse(Call<ResponseAnime> call, Response<ResponseAnime> response) {
                List<Result> mData = response.body().getResult();
                adapter = new RVAnime(AnimeListActivity.this, mData);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseAnime> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}