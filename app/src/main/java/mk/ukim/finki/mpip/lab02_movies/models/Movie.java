package mk.ukim.finki.mpip.lab02_movies.models;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("Title")
    private String Title;

    @SerializedName("Poster")
    private String Poster;

    @SerializedName("Year")
    private String Year;

    @SerializedName("Type")
    private String Type;

    public Movie(String imdbID, String title, String poster, String year, String type) {
        this.imdbID = imdbID;
        Title = title;
        Poster = poster;
        Year = year;
        Type = type;
    }

    public String getImdbID() { return imdbID; }

    public void setImdbID(String imdbID) { this.imdbID = imdbID; }

    public String getTitle() { return Title; }

    public void setTitle(String title) { Title = title; }

    public String getPoster() { return Poster; }

    public void setPoster(String poster) { Poster = poster; }

    public String getYear() { return Year; }

    public void setYear(String year) { Year = year; }

    public String getType() { return Type; }

    public void setType(String type) { Type = type; }
}
