package br.com.hebertmorais.movierating.entities;

/**
 * Created by Lucas on 27/04/16.
 */
public class Movie {
    private int rating;
    private String title;
    private String description;
    private String bannerUrl;

    public Movie(String title, String description, int rating, String bannerUrl ){
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.bannerUrl = bannerUrl;
    }

    public int getRating() {
        return rating;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
