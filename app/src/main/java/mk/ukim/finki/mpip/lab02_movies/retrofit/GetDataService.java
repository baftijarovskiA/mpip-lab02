package mk.ukim.finki.mpip.lab02_movies.retrofit;

import mk.ukim.finki.mpip.lab02_movies.models.Movies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("?apikey=650243dd&type=movie")
    Call<Movies> getAllMovies(@Query("s") String Title);
}
