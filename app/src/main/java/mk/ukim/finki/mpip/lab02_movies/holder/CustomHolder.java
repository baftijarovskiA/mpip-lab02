package mk.ukim.finki.mpip.lab02_movies.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import mk.ukim.finki.mpip.lab02_movies.R;


public class CustomHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView imageViewCover;
    public TextView textViewTitle;
    public TextView textViewYear;
    public ItemClickListener itemClickListener;

    public CustomHolder(@NonNull View itemView) {
        super(itemView);

        this.imageViewCover = itemView.findViewById(R.id.coverImage);
        this.textViewTitle = itemView.findViewById(R.id.title);
        this.textViewYear = itemView.findViewById(R.id.year);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }
}
