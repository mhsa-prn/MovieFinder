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

    private Context context;


    public NewFragmentAdapter(ArrayList<New> newMovies,Context context){
        this.newMovies=newMovies;
        this.context=context;
    }
    @NonNull
    @Override
    public NewFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_new,parent,false);

        final ViewHolder viewHolder=new ViewHolder(view);


        /*viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Main2Activity.class);
                intent.putExtra("title",newMovies.get(viewHolder.getAdapterPosition()).getmTitleNew());
                intent.putExtra("overview",newMovies.get(viewHolder.getAdapterPosition()).getmOverview());
                intent.putExtra("poster_path",newMovies.get(viewHolder.getAdapterPosition()).getmPosterPath());
                context.startActivity(intent);

            }
        });*/




        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final NewFragmentAdapter.ViewHolder holder, final int position) {

        final New newF=newMovies.get(position);
        holder.tvMovieTitleNew.setText(newF.getmTitleNew());
        holder.tvMovieScoreNew.setText(newF.getmPopularityNew());
        Glide.with(holder.ivMovieNew).load(newF.getmPosterPath()).into(holder.ivMovieNew);














       /*holder.linearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,Main2Activity.class);

                intent.putExtra("title",newF.getmTitleNew());
                intent.putExtra("overview",newF.getmOverview());
                intent.putExtra("poster_path",newF.getmPosterPath());
                context.startActivity(intent);
            }
        });*/


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




            ivMovieNew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,Main2Activity.class);

                    New newF=newMovies.get(getAdapterPosition());
                    intent.putExtra("title",newF.getmTitleNew());
                    intent.putExtra("overview",newF.getmOverview());
                    intent.putExtra("posterPath",newF.getmPosterPath());

                    context.startActivity(intent);
                }
            });
        }
    }
}
