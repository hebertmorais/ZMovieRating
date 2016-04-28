package br.com.hebertmorais.movierating.operators;

import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;

import java.util.List;

import br.com.hebertmorais.movierating.entities.Movie;

/**
 * Created by Lucas on 27/04/16.
 */
public interface MovieOperatorsInterface {

    public void addImagesToSlider(SliderLayout slider);

    public void addMoviesToListView(ListView listView);
}
