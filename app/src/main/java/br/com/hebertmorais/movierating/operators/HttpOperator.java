package br.com.hebertmorais.movierating.operators;

import android.content.Context;

import org.json.*;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Lucas on 28/04/16.
 */
public abstract class HttpOperator {

    public static String SUCCESS = "success";
    public static String FAIL = "fail";

    private AsyncHttpClient client;
    private Context context;

    public HttpOperator(Context context){
        client = new AsyncHttpClient();
        this.context = context;

    }

    public void get(String url){


        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                httpResponse( timeline, SUCCESS);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                httpResponse( null, FAIL);

            }

        });
    }

    protected abstract void httpResponse(JSONArray jsonArray, String fail);
}
