package me.mahsapiran.moviefinder;

public class New {
    String mTitleNew,mPopularityNew,mPosterPath,mOverview;



    public New(String title, String popularity, String poster_path, String overview) {
        this.mTitleNew=title;
        this.mPopularityNew=popularity;
        this.mPosterPath="https://image.tmdb.org/t/p/w500"+poster_path;
        this.mOverview=overview;
    }

    public String getmTitleNew() {
        return mTitleNew;
    }

    public String getmPopularityNew() {
        return mPopularityNew;
    }

    public String getmPosterPath() {
        return mPosterPath;
    }
    public String getmOverview() {
        return mOverview;
    }
}
