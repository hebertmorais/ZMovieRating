package br.com.hebertmorais.movierating.database;

import java.util.HashMap;

/**
 * Created by Lucas on 28/04/16.
 */
public interface DatabaseOperationsInterface {

    public void saveMovieFavorite(String id);

    public boolean getMovieFavorite(String id);
}
