package me.mahsapiran.moviefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String title=getIntent().getExtras().getString("title");
        String overview=getIntent().getExtras().getString("overview");
        String poster_path=getIntent().getExtras().getString("posterPath");

        TextView tvTitle=findViewById(R.id.tvActivity2Title);
        TextView tvOverview=findViewById(R.id.tvActivity2Overview);
        ImageView ivPoster=findViewById(R.id.ivActivity2);

        tvTitle.setText(title);
        tvOverview.setText(overview);
        Glide.with(ivPoster).load(poster_path).into(ivPoster);
    }
}
