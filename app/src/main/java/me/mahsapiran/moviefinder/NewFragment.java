package me.mahsapiran.moviefinder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */


public class NewFragment extends Fragment {

    private ProgressBar progressBar;
    private RecyclerView rvNew;
    private static final String TAG=NewFragment.class.getSimpleName();
    ArrayList<New> newMovies;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_new, container, false);

        //define views
        progressBar=root.findViewById(R.id.pbNew);
        rvNew=root.findViewById(R.id.rvNew);
        rvNew.setLayoutManager(new LinearLayoutManager(getActivity()));

        //call volley method
        getDataFromServer();


        return root;
    }

    private void showRecyclerView(){
        NewFragmentAdapter newFragmentAdapter=new NewFragmentAdapter(newMovies);
        rvNew.setAdapter(newFragmentAdapter);
    }

    private void getDataFromServer() {
        String url="https://api.themoviedb.org/3/movie/now_playing?api_key=0d43c16b0f65f3f26136a48b3b831525";
        newMovies=new ArrayList<>();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e(TAG, "On Response: " + response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);
                            newMovies.add(new New(data.getString("title"), data.getString(
                                    "popularity"), data.getString("poster_path")
                            ));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG,"On Response: "+error);
                    }
                });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }




}

