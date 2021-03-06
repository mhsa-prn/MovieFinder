package me.mahsapiran.moviefinder;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

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


public class NewFragment extends Fragment {

    private ProgressBar progressBar;
    private RecyclerView rvNew;
    private RequestQueue requestQueue;
    private static final String TAG=NewFragment.class.getSimpleName();
    ArrayList<New> newMovies;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_new, container, false);

        //define views
        requestQueue = Volley.newRequestQueue(getActivity());
        progressBar=root.findViewById(R.id.pbNew);
        rvNew=(RecyclerView) root.findViewById(R.id.rvNew);
        rvNew.setLayoutManager(new LinearLayoutManager(getActivity()));

        //call volley method
        getDataFromServer();


        return root;
    }

    public void showRecyclerView(){

        NewFragmentAdapter newFragmentAdapter=new NewFragmentAdapter(newMovies,getContext());
        rvNew.setAdapter(newFragmentAdapter);

    }

    private void getDataFromServer() {
        String url="https://api.themoviedb.org/3/movie/now_playing?api_key=0d43c16b0f65f3f26136a48b3b831525";
        newMovies=new ArrayList<>();
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e(TAG, "On Response: " + response);
                    try {
                        JSONArray jsonArray = response.getJSONArray("results");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject data = jsonArray.getJSONObject(i);
                                newMovies.add(new New(data.getString("title"), data.getString(
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


    /*public void tvNewClicked (View view){
        MainActivity mainActivity=new MainActivity();
        //Main2Activity main2Activity=new Main2Activity();
        //TextView textView=(TextView)view;
        Intent intent=new Intent(mainActivity,Main2Activity.class);
    }*/



}

