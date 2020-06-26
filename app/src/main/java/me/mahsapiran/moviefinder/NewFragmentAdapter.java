package me.mahsapiran.moviefinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewFragmentAdapter extends RecyclerView.Adapter<NewFragmentAdapter.ViewHolder> {

    ArrayList<NewFragment> newFragments;

    public NewFragmentAdapter(ArrayList<NewFragment> newFragments){
        this.newFragments=newFragments;

    }
    @NonNull
    @Override
    public NewFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_new_movieTitle,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewFragmentAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
