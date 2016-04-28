package br.com.hebertmorais.movierating.operators;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import br.com.hebertmorais.movierating.entities.Movie;

/**
 * Created by Lucas on 27/04/16.
 */
public class MovieOperator implements MovieOperatorsInterface {

    private List<Movie> movies;

    public MovieOperator(){
        moviesCreator();
    }

    public void moviesCreator() {

        Movie movie1 = new Movie("Game of Thrones","Description GOT", 0, "url");
        Movie movie2 = new Movie("Breaking Bad","Description Breaking Bad", 0, "url");
        Movie movie3 = new Movie("House MD","Description House", 0, "url");
        Movie movie4 = new Movie("Sons of Anarchy","SOA Description", 0, "url");
        Movie movie5 = new Movie("Vikings","Vikings Description", 0, "url");
        Movie movie6 = new Movie("The Walking Dead","TWD Description", 0, "url");
        Movie movie7 = new Movie("Friends","Friends Description", 0, "url");

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);

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
    public void addImagesToSlider(SliderLayout slider){
        bindMoviesToSlider(slider, movies);
    }

    @Override
    public void addMoviesToListView(ListView moviesListView) {
        Context context = moviesListView.getContext();
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, getMoviesTitles(movies));
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
