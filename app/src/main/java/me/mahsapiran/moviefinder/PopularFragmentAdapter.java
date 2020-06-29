package me.mahsapiran.moviefinder;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
public class PopularFragmentAdapter extends RecyclerView.Adapter<PopularFragmentAdapter.ViewHolder> {
    PopularFragment popularFragment=new PopularFragment();
    ArrayList<Popular> popularMovies;
    Context context;


    public PopularFragmentAdapter(ArrayList<Popular> popularMovies, Context context){
        this.popularMovies=popularMovies;
        this.context=context;
    }

    @NonNull
    @Override
    public PopularFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_popular,parent,false);
        return new PopularFragmentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Popular popularF=popularMovies.get(position);
        holder.tvMovieTitlePopular.setText(popularF.getmTitlePopular());
        holder.tvMovieScorePopular.setText(popularF.getmPopularityPopular());
        Glide.with(holder.ivMoviePopular).load(popularF.getmPosterPath()).into(holder.ivMoviePopular);
    }

    @Override
    public int getItemCount() {
        return popularMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMovieTitlePopular,tvMovieScorePopular;
        ImageView ivMoviePopular;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tvMovieTitlePopular=itemView.findViewById(R.id.tvMovieTitlePopular);
            tvMovieScorePopular=itemView.findViewById(R.id.tvMovieScorePopular);
            ivMoviePopular=itemView.findViewById(R.id.ivMoviePopular);

            ivMoviePopular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,Main2Activity.class);

                    Popular popularF=popularMovies.get(getAdapterPosition());
                    intent.putExtra("title",popularF.getmTitlePopular());
                    intent.putExtra("overview",popularF.getMoverview());
                    intent.putExtra("posterPath",popularF.getmPosterPath());

                    context.startActivity(intent);
                }
            });
        }
    }
    }

