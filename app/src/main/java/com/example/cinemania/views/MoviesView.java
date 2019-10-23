package com.example.cinemania.views;

import com.example.cinemania.data.model.Movies;

import java.util.ArrayList;

public interface MoviesView {
    void moviesReady(ArrayList<Movies> movies);
}
