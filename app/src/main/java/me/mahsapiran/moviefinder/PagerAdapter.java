package me.mahsapiran.moviefinder;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;
    public PagerAdapter(FragmentManager fm,int numberOfTabs){
        super(fm);
        this.numberOfTabs=numberOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new NewFragment();

            case 1:
                return new PopularFragment();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
