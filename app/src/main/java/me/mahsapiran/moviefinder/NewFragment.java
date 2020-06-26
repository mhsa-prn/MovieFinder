package me.mahsapiran.moviefinder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment {

    //define variables
    String imageUrl,movieTitle,movieDirector,movieGenre;
    private ProgressBar progressBar;

    //create constructor method
    public NewFragment(String imageUrl,String movieTitle, String movieDirector, String movieGenre) {
       this.imageUrl=imageUrl;
       this.movieTitle=movieTitle;
       this.movieDirector=movieDirector;
       this.movieGenre=movieGenre;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_new, container, false);

        //define progress bar
        progressBar=root.findViewById(R.id.pbNew);

        return root;
    }
}
