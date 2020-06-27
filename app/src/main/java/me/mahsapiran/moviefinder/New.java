package me.mahsapiran.moviefinder;

public class New {
    String mTitleNew,mPopularityNew,mPosterPath;

    public New(String title, String popularity, String poster_path) {
        this.mTitleNew=title;
        this.mPopularityNew=popularity;
        this.mPosterPath=poster_path;
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
}
