package me.mahsapiran.moviefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater flater=getMenuInflater();
        flater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
