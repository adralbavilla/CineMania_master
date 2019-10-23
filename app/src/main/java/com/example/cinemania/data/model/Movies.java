package com.example.cinemania.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Movies implements Serializable {
    @SerializedName("poster_path")
    public String poster_path;
    @SerializedName("adult")
    public Boolean adult;
    @SerializedName("overview")
    public String overview;
    @SerializedName("release_date")
    public String release_date;
    @SerializedName("id")
    public Integer id;
    @SerializedName("original_title")
    public String original_title;
    @SerializedName("original_language")
    public String original_language;
    @SerializedName("title")
    public String title;
    @SerializedName("backdrop_path")
    public String backdrop_path;
    @SerializedName("popularity")
    public Number popularity;
    @SerializedName("vote_count")
    public Integer vote_count;
    @SerializedName("video")
    public Boolean video;

    public String getPoster_path() {
        return poster_path;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Integer getId() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public Number getPopularity() {
        return popularity;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public Boolean getVideo() {
        return video;
    }
}
