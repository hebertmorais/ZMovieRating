package br.com.hebertmorais.movierating.operators;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;

import br.com.hebertmorais.movierating.entities.Movie;

/**
 * Created by Lucas on 27/04/16.
 */
public class MovieOperator implements MovieOperatorsInterface {

    private List<Movie> movies;

    public MovieOperator(){
        this.movies = moviesCreator();
    }

    private List<Movie> moviesCreator() {

        ArrayList<Movie> response = new ArrayList<>();
        Movie movie1 = new Movie("Game of Thrones","Description GOT", 0, "https://pbs.twimg.com/profile_images/702545332475981824/Mg7TpOaw.jpg");
        Movie movie2 = new Movie("Breaking Bad","Description Breaking Bad", 0, "https://lh6.googleusercontent.com/-70Hlzc775lA/AAAAAAAAAAI/AAAAAAAAAPc/cJmmz52JCGE/s0-c-k-no-ns/photo.jpg");
        Movie movie3 = new Movie("House MD","Description House", 0, "http://www.bolumrehberi.com/images/tv-show/House-MD/dr_gregory_house_wallpaper_1920x1200_1.jpg");
        Movie movie4 = new Movie("Sons of Anarchy","SOA Description", 0, "http://www.cutthecap.com/wp-content/uploads/2014/10/2684i59B5472A67FEB352.jpg");
        Movie movie5 = new Movie("Vikings","Vikings Description", 0, "https://pmctvline2.files.wordpress.com/2015/01/vikings_season3_horiz.jpg");
        Movie movie6 = new Movie("The Walking Dead","TWD Description", 0, "https://images2.alphacoders.com/240/240942.jpg");
        Movie movie7 = new Movie("Friends","Friends Description", 0, "http://static.omelete.uol.com.br/media/extras/conteudos/0aa3afb3cbe3468fc6e43e50070b0810_HQi5OtO.png");

        response.add(movie1);
        response.add(movie2);
        response.add(movie3);
        response.add(movie4);
        response.add(movie5);
        response.add(movie6);
        response.add(movie7);

        return response;
    }

    public void bindMoviesToSlider(SliderLayout slider, List<Movie> movies) {

        for ( Movie m : movies){
            TextSliderView textSliderView = new TextSliderView(slider.getContext());
            textSliderView
                    .description(m.getTitle())
                    .image(m.getBannerUrl());

            slider.addSlider(textSliderView);
        }

    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public void addImagesToSlider(SliderLayout slider){
        bindMoviesToSlider(slider, getMovies());
    }

    @Override
    public void addMoviesToListView(ListView moviesListView) {
        Context context = moviesListView.getContext();
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, getMoviesTitles(getMovies()));
        moviesListView.setAdapter(itemsAdapter);
    }

    private List<String> getMoviesTitles(List<Movie> movies){
        ArrayList<String> response = new ArrayList<>();

        for (Movie m: movies){
            response.add(m.getTitle());
        }

        return response;
    }
}
