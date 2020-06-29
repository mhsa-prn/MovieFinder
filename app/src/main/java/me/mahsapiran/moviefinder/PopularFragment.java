package me.mahsapiran.moviefinder;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {
    private ProgressBar progressBar;
    private RecyclerView rvPopular;
    private RequestQueue requestQueue;
    private static final String TAG=NewFragment.class.getSimpleName();
    ArrayList<Popular> popularMovies;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_popular, container, false);

        //define views
        requestQueue = Volley.newRequestQueue(getActivity());
        progressBar=root.findViewById(R.id.pbPopular);
        rvPopular=root.findViewById(R.id.rvPopular);
        rvPopular.setLayoutManager(new LinearLayoutManager(getActivity()));

        //call volley method
        getDataFromServer();


        return root;
    }

    private void showRecyclerView(){
        PopularFragmentAdapter popularFragmentAdapter=new PopularFragmentAdapter(popularMovies,getActivity());
        rvPopular.setAdapter(popularFragmentAdapter);
    }

    private void getDataFromServer() {
        String url="https://api.themoviedb.org/3/movie/popular?api_key=0d43c16b0f65f3f26136a48b3b831525";
        popularMovies=new ArrayList<>();
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                if (response != null) {
                    progressBar.setVisibility(View.GONE);
                    Log.e(TAG, "On Response: " + response);
                    try {
                        JSONArray jsonArray = response.getJSONArray("results");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                            JSONObject data = jsonArray.getJSONObject(i);
                            popularMovies.add(new Popular(data.getString("title"), data.getString(
                                    "popularity"), data.getString("poster_path"),data.getString("overview")
                            ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        showRecyclerView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e(TAG,"On Response: "+error);
                    }
                });
        requestQueue.add(jsonObjectRequest);


    }




}


