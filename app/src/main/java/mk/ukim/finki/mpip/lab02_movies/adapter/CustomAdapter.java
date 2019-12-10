package mk.ukim.finki.mpip.lab02_movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import mk.ukim.finki.mpip.lab02_movies.PreviewActivity;
import mk.ukim.finki.mpip.lab02_movies.R;
import mk.ukim.finki.mpip.lab02_movies.holder.CustomHolder;
import mk.ukim.finki.mpip.lab02_movies.holder.ItemClickListener;
import mk.ukim.finki.mpip.lab02_movies.models.Movie;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomHolder> {

    Context context;
    List<Movie> movies;

    public CustomAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_row,null);

        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder customHolder, final int i) {

        customHolder.textViewTitle.setText(movies.get(i).getTitle());
        customHolder.textViewYear.setText(movies.get(i).getYear());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(movies.get(i).getPoster())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(customHolder.imageViewCover);

        customHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String gTitle = movies.get(i).getTitle();
                String gYear = movies.get(i).getYear();
                String gCover = movies.get(i).getPoster();

                Intent intent = new Intent(context, PreviewActivity.class);
                intent.putExtra("iTitle",gTitle);
                intent.putExtra("iCover",gCover);
                intent.putExtra("iYear",gYear);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}