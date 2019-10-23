package com.example.cinemania.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;

import com.example.cinemania.data.source.remote.MovieService;
import com.example.cinemania.data.model.Movies;
import com.example.cinemania.data.model.MoviesGeneral;
import com.example.cinemania.utilities.Constants;
import com.example.cinemania.views.MoviesView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter {
    List<Movies> imageUrls;
    ArrayList<String> stringArrayList = new ArrayList<String>();
    TextView txtView;
    public Context context;
    private MoviesView moviesView;
    private MovieService movieService;

    public MoviePresenter(MoviesView view) {
        this.moviesView = view;

        if (this.movieService == null) {
            this.movieService = new MovieService();

        }
    }

    public void getMovies() {
        movieService.getApiService()
                .getTopRatedMovies(Constants.API_KEY, Constants.language, 1)
                .enqueue(new Callback<MoviesGeneral>() {
                    @Override
                    public void onResponse(@NonNull Call<MoviesGeneral> call, @NonNull Response<MoviesGeneral> response) {
                        if (response.isSuccessful()) {
                            Gson gson = new Gson();
                            String successResponse = gson.toJson(response.body());
                            Log.i("successResponse: ", successResponse);


                            ArrayList<Movies> movies = response.body().getMovieResult();
                            for (Movies movie : movies) {
                                moviesView.moviesReady(movies);
                                //stringArrayList.add(moviePathUrl(movie.getPoster_path()));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesGeneral> call, Throwable t) {

                    }
                });
    }

    public static String moviePathUrl(String imagePath) {
        return Constants.moviePathUrl + imagePath;
    }
}
