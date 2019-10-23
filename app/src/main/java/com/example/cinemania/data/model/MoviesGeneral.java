package com.example.cinemania.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MoviesGeneral {
    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private ArrayList<Movies> movieResult;

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public ArrayList<Movies> getMovieResult() {
        return movieResult;
    }
}
