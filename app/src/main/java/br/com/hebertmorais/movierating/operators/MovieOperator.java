package br.com.hebertmorais.movierating.operators;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.hebertmorais.movierating.R;
import br.com.hebertmorais.movierating.activities.MovieDetail;
import br.com.hebertmorais.movierating.entities.Movie;

/**
 * Created by Lucas on 27/04/16.
 */
public class MovieOperator implements MovieOperatorsInterface {

    public static final String MOVIE_EXTRA = "movie";
    private final ProgressDialog mProgress;
    private final Context context;
    private List<Movie> movies;
    private SliderLayout slider;
    private ListView listView;

    public MovieOperator(SliderLayout mSliderShow, ListView mMoviesListView){
        String initialPage = "https://api.themoviedb.org/3/search/multi?api_key=47ef6cd90c98b57fb21a3aef91be9536&query=friends&language=en";

        this.slider = mSliderShow;
        this.listView = mMoviesListView;
        this.context = mSliderShow.getContext();

        mProgress = new ProgressDialog(context);
        mProgress.setMessage(context.getString(R.string.loading));
        mProgress.setIndeterminate(false);
        mProgress.setCancelable(false);

        moviesCreator(initialPage);

    }

    private void updateListAndSlider(){
        addImagesToSlider(slider);
        addMoviesToListView(listView);
    }
    private List<Movie> moviesCreator(String url) {

        mProgress.show();

        ArrayList<Movie> response = new ArrayList<>();

        HttpOperator operator = new HttpOperator() {
            @Override
            protected void httpResponse(String jsonObject, String response) {
                mProgress.dismiss();
                if (response.equals(HttpOperator.SUCCESS)) {
                    try {
                        movies = JSONParser.getMovies(new JSONObject(jsonObject));
                        updateListAndSlider();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_LONG ).show();
                }
            }
        };

        operator.get(url);

        return response;
    }

    public void bindMoviesToSlider(SliderLayout slider, List<Movie> movies) {

        slider.removeAllSliders();

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

    public void searchMovies(String query, ListView moviesListView) {
        String url = "https://api.themoviedb.org/3/search/multi?api_key=47ef6cd90c98b57fb21a3aef91be9536&query=" + query + "&language=en";
        movies = moviesCreator(url);
    }


}
