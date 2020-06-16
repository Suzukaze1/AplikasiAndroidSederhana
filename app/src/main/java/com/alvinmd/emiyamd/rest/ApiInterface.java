package com.alvinmd.emiyamd.rest;

import com.alvinmd.emiyamd.model.ResponseAnime;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/AnimeRead.php")
    Call<ResponseAnime> getAnime();
}
