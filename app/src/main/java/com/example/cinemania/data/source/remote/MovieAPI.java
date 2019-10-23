package com.example.cinemania.data.source.remote;

import com.example.cinemania.data.model.MoviesGeneral;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {
    @GET("movie/top_rated")
    Call<MoviesGeneral> getTopRatedMovies(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page
    );
}
