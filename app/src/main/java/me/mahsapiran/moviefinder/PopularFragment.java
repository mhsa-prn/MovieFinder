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
public class PopularFragment extends Fragment {
    private ProgressBar progressBar;
    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_popular, container, false);

        //define progress bar
        progressBar =root.findViewById(R.id.pbPopular);

        return root;
    }
}
