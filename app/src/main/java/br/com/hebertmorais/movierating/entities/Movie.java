package br.com.hebertmorais.movierating.entities;

import java.io.Serializable;

/**
 * Created by Lucas on 27/04/16.
 */
public class Movie implements Serializable{
    private double rating;
    private String title;
    private String description;
    private String bannerUrl;
    private boolean isFavorite;
    private String id;

    public Movie(String id, String title, String description, String bannerUrl ){
        this.id = id;
        this.title = title;
        this.description = description;
        this.bannerUrl = bannerUrl;
        this.rating = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
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

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
