package me.mahsapiran.moviefinder;

public class Popular {
    String mTitlePopular,mPopularityPopular,mPosterPath,moverview;



    public Popular(String title, String popularity, String poster_path, String overview) {
        this.mTitlePopular=title;
        this.mPopularityPopular=popularity;
        this.mPosterPath="https://image.tmdb.org/t/p/w500"+poster_path;
        this.moverview=overview;
    }

    public String getmTitlePopular() {

        return mTitlePopular;
    }

    public String getmPopularityPopular() {
        return mPopularityPopular;
    }

    public String getmPosterPath() {
        return mPosterPath;
    }

    public String getMoverview(){
        return  moverview;
    }
}

