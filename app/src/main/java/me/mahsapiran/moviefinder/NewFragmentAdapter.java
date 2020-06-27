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

public class NewFragmentAdapter extends RecyclerView.Adapter<NewFragmentAdapter.ViewHolder> {
    NewFragment newFragment=new NewFragment();
    ArrayList<New> newMovies;


    public NewFragmentAdapter(ArrayList<New> newMovies){
        this.newMovies=newMovies;

    }
    @NonNull
    @Override
    public NewFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_new,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewFragmentAdapter.ViewHolder holder, int position) {

        New newF=newMovies.get(position);
        holder.tvMovieTitleNew.setText(newF.getmTitleNew());
        holder.tvMovieScoreNew.setText(newF.getmPopularityNew());
        Glide.with(holder.ivMovieNew).load(newF.getmPosterPath()).into(holder.ivMovieNew);

        //holder.ivMovieNew.setImageResource(newFragment.imageNew);
    }

    @Override
    public int getItemCount() {

        return newMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieTitleNew,tvMovieScoreNew;
        ImageView ivMovieNew;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tvMovieTitleNew=itemView.findViewById(R.id.tvMovieTitleNew);
            tvMovieScoreNew=itemView.findViewById(R.id.tvMovieScoreNew);
            ivMovieNew=itemView.findViewById(R.id.ivMovieNew);
        }
    }
}
