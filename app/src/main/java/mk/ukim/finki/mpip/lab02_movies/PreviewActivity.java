package mk.ukim.finki.mpip.lab02_movies;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class PreviewActivity extends AppCompatActivity {

    TextView textViewTitle;
    TextView textViewYear;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        ActionBar actionBar = getSupportActionBar();

        textViewTitle = findViewById(R.id.title);
        imageView = findViewById(R.id.coverImage);
        textViewYear = findViewById(R.id.year);

        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("iTitle");
        String mYear = intent.getStringExtra("iYear");
        String mCover = intent.getStringExtra("iCover");

        assert actionBar != null;
        actionBar.setTitle(mTitle);

        textViewTitle.setText(mTitle);
        textViewYear.setText(mYear);

        Picasso.Builder builder = new Picasso.Builder(this.getBaseContext());
        builder.downloader(new OkHttp3Downloader(this.getBaseContext()));
        builder.build().load(mCover)
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
