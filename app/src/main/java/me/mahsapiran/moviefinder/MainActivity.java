package me.mahsapiran.moviefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvNew,rvPopular;
    ImageView ivMovieNew;
    TextView tvMovieTitleNew,tvMovieGenreNew,tvMovieDirectorNew,tvMovieScoreNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define texts views
        tvMovieTitleNew=findViewById(R.id.tvMovieTitleNew);
        tvMovieGenreNew=findViewById(R.id.tvMovieGenreNew);
        tvMovieDirectorNew=findViewById(R.id.tvMovieDirectorNew);
        tvMovieScoreNew=findViewById(R.id.tvMovieScoreNew);

        //define images view
        ivMovieNew=findViewById(R.id.ivMovieNew);


        //define toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //define tab layout and items (tabbar)
        TabLayout tabLayout=findViewById(R.id.tabbar);
        TabItem tabbarNew=findViewById(R.id.tabbar_item_new);
        TabItem tabbarPopular=findViewById(R.id.tabbar_item_popular);

        //define viewPager
        final ViewPager viewPager=findViewById(R.id.viewPager);

        //define pagee adapter
        PagerAdapter pagerAdapter=new PagerAdapter(
                getSupportFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        //change the tabs view when the tab is selected or clicked
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //define recyclers view
        rvNew=findViewById(R.id.rvNew);
        rvPopular=findViewById(R.id.rvPopular);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater flater=getMenuInflater();
        flater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
