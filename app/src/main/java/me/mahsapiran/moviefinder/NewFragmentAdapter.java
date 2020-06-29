package me.mahsapiran.moviefinder;

import android.content.Context;
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

    private ArrayList<New> newMovies;

    private Context context;


    public NewFragmentAdapter(ArrayList<New> newMovies,Context context){
        this.newMovies=newMovies;
        this.context=context;
    }
    @NonNull
    @Override
    public NewFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_new,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewFragmentAdapter.ViewHolder holder, int position) {

        New newF=newMovies.get(position);
        holder.tvMovieTitleNew.setText(newF.getmTitleNew());
        holder.tvMovieScoreNew.setText(newF.getmPopularityNew());
        Glide.with(holder.ivMovieNew).load(newF.getmPosterPath()).into(holder.ivMovieNew);

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
            tvMovieTitleNew=(TextView) itemView.findViewById(R.id.tvMovieTitleNew);
            tvMovieScoreNew=(TextView) itemView.findViewById(R.id.tvMovieScoreNew);
            ivMovieNew=(ImageView) itemView.findViewById(R.id.ivMovieNew);
        }
    }
}
