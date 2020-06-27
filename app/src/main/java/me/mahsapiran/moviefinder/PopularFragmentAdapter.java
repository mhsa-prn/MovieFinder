package me.mahsapiran.moviefinder;
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


    public PopularFragmentAdapter(ArrayList<Popular> popularMovies){
        this.popularMovies=popularMovies;

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
        }
    }
    }

