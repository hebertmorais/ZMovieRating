package br.com.hebertmorais.movierating.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;

import br.com.hebertmorais.movierating.R;
import br.com.hebertmorais.movierating.entities.Movie;
import br.com.hebertmorais.movierating.operators.MovieOperator;
import br.com.hebertmorais.movierating.operators.MovieDetailOperator;

public class MovieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        PullToZoomScrollViewEx scrollView = (PullToZoomScrollViewEx) findViewById(R.id.scroll_view);
        MovieDetailOperator.initZoomScrollView(scrollView);

        Intent i = getIntent();
        Movie movie = (Movie) i.getSerializableExtra(MovieOperator.MOVIE_EXTRA);
        getSupportActionBar().setTitle(movie.getTitle());

        MovieDetailOperator.bindMovieToView(movie, scrollView);
    }

}
