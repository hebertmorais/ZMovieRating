package br.com.hebertmorais.movierating.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import br.com.hebertmorais.movierating.R;
import br.com.hebertmorais.movierating.database.DatabaseOperator;
import br.com.hebertmorais.movierating.operators.MovieOperator;

public class MainActivity extends AppCompatActivity {

    private SliderLayout mSliderShow;
    private ListView mMoviesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        DatabaseOperator.loadDatabase(this);

        MovieOperator operator = new MovieOperator();
        operator.addImagesToSlider(mSliderShow);
        operator.addMoviesToListView(mMoviesListView);

    }

    private void initViews() {
        mSliderShow = (SliderLayout) findViewById(R.id.slider);
        mMoviesListView = (ListView) findViewById(R.id.movies_listView);
    }

    @Override
    protected void onStop() {
        mSliderShow.stopAutoCycle();
        super.onStop();
    }
}
