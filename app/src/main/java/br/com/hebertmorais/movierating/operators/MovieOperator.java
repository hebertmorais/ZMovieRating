package br.com.hebertmorais.movierating.operators;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;

import br.com.hebertmorais.movierating.activities.MovieDetail;
import br.com.hebertmorais.movierating.entities.Movie;

/**
 * Created by Lucas on 27/04/16.
 */
public class MovieOperator implements MovieOperatorsInterface {

    public static final String MOVIE_EXTRA = "movie";
    private List<Movie> movies;

    public MovieOperator(){
        this.movies = moviesCreator();
    }

    private List<Movie> moviesCreator() {

        ArrayList<Movie> response = new ArrayList<>();
        Movie movie1 = new Movie("Game of Thrones","Description GOT", 0, "https://static.omelete.uol.com.br/media/extras/conteudos/gameofthrones_logo_mQkVfzJ_Tpf2KK9.jpg");
        Movie movie2 = new Movie("Breaking Bad","Description Breaking Bad", 0, "http://2.bp.blogspot.com/-Mfpl-9MdFmk/Vd44vG0OBEI/AAAAAAAAHHk/KFOs_dJLfZg/s620/Breaking-Bad-Season-5.jpg");
        Movie movie3 = new Movie("House MD","Description House", 0, "http://i.onionstatic.com/avclub/5024/33/16x9/960.jpg");
        Movie movie4 = new Movie("Sons of Anarchy","SOA Description", 0, "http://www.cutthecap.com/wp-content/uploads/2014/10/2684i59B5472A67FEB352.jpg");
        Movie movie5 = new Movie("Vikings","Vikings Description", 0, "https://static.hbonordic.com/1f10ced-0049c77cbf7/HBON-AAGBK-000-PGM-01-01-2500-HD-169-SR-1920x1080-50-6228414.jpg");
        Movie movie6 = new Movie("The Walking Dead","TWD Description", 0, "http://www.wallpapertycoon.com/download/4236/2016/02/the_walking_dead_s01e02_games_wallpaper-960x540.jpg/");
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
        final Context context = moviesListView.getContext();
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, getMoviesTitles(getMovies()));
        moviesListView.setAdapter(itemsAdapter);

        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(context, MovieDetail.class);
                i.putExtra(MOVIE_EXTRA, getMovies().get(position));
                context.startActivity(i);
            }
        });
    }

    private List<String> getMoviesTitles(List<Movie> movies){
        ArrayList<String> response = new ArrayList<>();

        for (Movie m: movies){
            response.add(m.getTitle());
        }

        return response;
    }
}
