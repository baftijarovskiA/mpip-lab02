package mk.ukim.finki.mpip.lab02_movies;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.Toast;
import mk.ukim.finki.mpip.lab02_movies.adapter.CustomAdapter;
import mk.ukim.finki.mpip.lab02_movies.models.Movie;
import mk.ukim.finki.mpip.lab02_movies.retrofit.GetDataService;
import mk.ukim.finki.mpip.lab02_movies.retrofit.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class Movies extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        CallRetrofit(query);
    }


    public void CallRetrofit(String query){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<mk.ukim.finki.mpip.lab02_movies.models.Movies> call = service.getAllMovies(query);
        call.enqueue(new Callback<mk.ukim.finki.mpip.lab02_movies.models.Movies>() {
            @Override
            public void onResponse(Call<mk.ukim.finki.mpip.lab02_movies.models.Movies> call, Response<mk.ukim.finki.mpip.lab02_movies.models.Movies> response) {
                generateOnlineData(response.body());
//                Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<mk.ukim.finki.mpip.lab02_movies.models.Movies> call, Throwable t) {
                generateOfflineData(moviesList());
                Toast.makeText(Movies.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void generateOnlineData(mk.ukim.finki.mpip.lab02_movies.models.Movies body) {
        recyclerView = findViewById(R.id.customRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter = new CustomAdapter(this, body.getMovieList());
        recyclerView.setAdapter(customAdapter);
    }

    private void generateOfflineData(List<Movie> body) {
        recyclerView = findViewById(R.id.customRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter = new CustomAdapter(this, body);
        recyclerView.setAdapter(customAdapter);
    }


    private List<Movie> moviesList() {
        List<Movie> movies = new ArrayList<>();

        Movie m = new Movie("tt5140878","Annabelle: Creation","https://m.media-amazon.com/images/M/MV5BMjA1MzIwMjMxNF5BMl5BanBnXkFtZTgwMDQ3NTc2MjI@._V1_SX300.jpg", "2017","movie");
        movies.add(m);
        m = new Movie("tt8350360","Annabelle Comes Home","https://m.media-amazon.com/images/M/MV5BYmI4NDNiMmQtZTFkYi00ZDVmLThlYTAtMWJlMjU1M2I2ZmViXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_SX300.jpg", "2019","movie");
        movies.add(m);

        return movies;
    }
}
