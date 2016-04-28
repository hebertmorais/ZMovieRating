package br.com.hebertmorais.movierating.activities;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import br.com.hebertmorais.movierating.R;
import br.com.hebertmorais.movierating.database.DatabaseOperator;
import br.com.hebertmorais.movierating.operators.MovieOperator;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private SliderLayout mSliderShow;
    private ListView mMoviesListView;
    private MovieOperator operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        DatabaseOperator.loadDatabase(this);

        operator = new MovieOperator();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
