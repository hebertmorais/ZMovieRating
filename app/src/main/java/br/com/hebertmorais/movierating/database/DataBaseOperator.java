package br.com.hebertmorais.movierating.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Lucas on 28/04/16.
 */
public class DatabaseOperator {

    private static final String DATABASE = "moviesratingdb";
    private static final String DATABASE_HASHMAP = "moviesratingdb-hashmap";
    private static HashMap<String, String> database;
    private static SharedPreferences sharedPreferences;

    public static void loadDatabase(Context context){

        sharedPreferences = context.getSharedPreferences(DATABASE, Context.MODE_PRIVATE);

        database = loadHashMap();
    }

    public static void saveMovieFavorite(String id, boolean isFavorite) {
        database.put(id, String.valueOf(isFavorite));
        save();
    }

    private static void save() {
        JSONObject jsonDatabase = new JSONObject(database);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DATABASE_HASHMAP, jsonDatabase.toString());
        editor.apply();
    }

    public static boolean getMovieFavorite(String id) {
        boolean response = false;

        for(Map.Entry<String, String> entry : database.entrySet()){
            if (entry.getKey().equals(id)) {
                response = Boolean.parseBoolean(entry.getValue());
                break;
            }
        }


        return response;
    }

    private static HashMap<String, String> loadHashMap(){

        if (database != null) return database;

        String jsonDatabase = getJsonDatabase();

        return getHashMapFromJson(jsonDatabase);
    }

    private static HashMap<String, String> getHashMapFromJson(String json){

        if(json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, String>>(){}.getType();
            return gson.fromJson(json, type);
        } else {
            return new HashMap<>();
        }
    }

    private static String getJsonDatabase() {
        return sharedPreferences.getString(DATABASE_HASHMAP, null);
    }
}
