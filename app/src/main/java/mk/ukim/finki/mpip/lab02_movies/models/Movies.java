package mk.ukim.finki.mpip.lab02_movies.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {

    @SerializedName("Search")
    private List<Movie> movieList;

    public List<Movie> getMovieList() { return movieList; }

    public void setMovieList(List<Movie> movieList) { this.movieList = movieList; }
}
