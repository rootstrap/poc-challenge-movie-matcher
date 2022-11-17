package com.moviematcher;

import java.util.List;

public class Movie2 {
    public List<String> genres;
    public Double id;
    public String overview;
    public String title;
    public String posterPath;
    public Boolean isInMyList;
    public Boolean isRecommended;

    public Movie2(
            List<String> genres,
            Double id,
            String title,
            String overview,
            String posterPath,
            Boolean isInMyList,
            Boolean isRecommended
    ) {
        this.genres = genres;
        this.id = id;
        this.overview = overview;
        this.title = title;
        this.posterPath = posterPath;
        this.isInMyList = isInMyList;
        this.isRecommended = isRecommended;
    }
}