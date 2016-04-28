package br.com.hebertmorais.movierating.operators;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.hebertmorais.movierating.entities.Movie;

/**
 * Created by Lucas on 28/04/16.
 */
public class JSONParser {

    public static Movie getMovieFromJson(JSONObject movieJson) throws JSONException{

        String imageBaseUrl = "http://image.tmdb.org/t/p/w500/";

        String title ;
        String mediaType = movieJson.getString("media_type");

        if(mediaType.equals("tv")){
            title = movieJson.getString("original_name");
        } else {
            title = movieJson.getString("original_title");
        }
        String description = movieJson.getString("overview");
        Double rating = movieJson.getDouble("vote_average")/2 ; //online db rating is from 0 to 10
        String bannerImage = imageBaseUrl + movieJson.getString("poster_path");
        String id = String.valueOf(movieJson.getInt("id"));

        Movie movie = new Movie(id, title, description, bannerImage);
        movie.setRating(rating);

        return movie;

    }
}
