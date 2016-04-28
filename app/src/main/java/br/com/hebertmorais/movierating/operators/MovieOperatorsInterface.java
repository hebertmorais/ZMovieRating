package br.com.hebertmorais.movierating.operators;

import com.daimajia.slider.library.SliderLayout;

import java.util.List;

import br.com.hebertmorais.movierating.entities.Movie;

/**
 * Created by Lucas on 27/04/16.
 */
public interface MovieOperatorsInterface {

    public List<Movie> MoviesCreator();

    public void setSlides(SliderLayout slider, List<Movie> movies);
}
