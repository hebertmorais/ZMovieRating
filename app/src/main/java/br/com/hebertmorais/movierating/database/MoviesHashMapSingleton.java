package br.com.hebertmorais.movierating.database;

import java.util.HashMap;

/**
 * Created by Lucas on 28/04/16.
 */
public class MoviesHashMapSingleton {
    private static HashMap<String, String> instance;

    private MoviesHashMapSingleton() {
    }

    public static HashMap<String, String> getInstance(){

        if(instance == null)
        {
            initInstance();

        }
        return instance;
    }

    /*
     *This method is synchronized in order to avoid the creation of multiple instances
     *
     */
    private static synchronized void initInstance()
    {
        if (instance == null)
        {
            instance = new HashMap<>();
        }
    }}
