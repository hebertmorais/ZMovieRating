package br.com.hebertmorais.movierating.operators;

import android.content.Context;

import org.json.*;

import com.google.gson.JsonObject;
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


        client.get(url, new BaseJsonHttpResponseHandler<JSONObject>() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, JSONObject response) {
                httpResponse(response, SUCCESS);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, JSONObject errorResponse) {
                httpResponse(null, FAIL);
            }

            @Override
            protected JSONObject parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                return null;
            }

        });
    }

    protected abstract void httpResponse(JSONObject jsonObject, String fail);
}
