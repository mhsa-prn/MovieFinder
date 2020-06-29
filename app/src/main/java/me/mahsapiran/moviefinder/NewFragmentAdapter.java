package me.mahsapiran.moviefinder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewFragmentAdapter extends RecyclerView.Adapter<NewFragmentAdapter.ViewHolder> {

    private ArrayList<New> newMovies;
    MainActivity ac;
    private Context context;


    public NewFragmentAdapter(ArrayList<New> newMovies,Context context){
        this.newMovies=newMovies;
        this.context=context;

    }
    @NonNull
    @Override
    public NewFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_new,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,Main2Activity.class);


                intent.putExtra("title",newMovies.get(viewHolder.getAdapterPosition()).getmTitleNew());
                intent.putExtra("overview",newMovies.get(viewHolder.getAdapterPosition()).getmOverview());
                intent.putExtra("PosterPath",newMovies.get(viewHolder.getAdapterPosition()).getmPosterPath());

                view.getContext().startActivity(intent);
            }
        });
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
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tvMovieTitleNew=(TextView) itemView.findViewById(R.id.tvMovieTitleNew);
            tvMovieScoreNew=(TextView) itemView.findViewById(R.id.tvMovieScoreNew);
            ivMovieNew=(ImageView) itemView.findViewById(R.id.ivMovieNew);
            linearLayout=itemView.findViewById(R.id.linearLayoutActivity2);
        }
    }
}
