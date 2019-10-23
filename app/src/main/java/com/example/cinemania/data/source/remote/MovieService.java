package com.example.cinemania.data.source.remote;

import com.example.cinemania.utilities.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieService {

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(Constants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //Colocar nombre de la Interface pata instanciar hacia la interface
    public static MovieAPI getApiService() {
        return getRetrofitInstance().create(MovieAPI.class);
    }
}
