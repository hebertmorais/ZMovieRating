package br.com.hebertmorais.movierating.operators;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Lucas on 28/04/16.
 */
public abstract class HttpOperator {

    public static String SUCCESS = "success";
    public static String FAIL = "fail";

    private AsyncHttpClient client;

    public HttpOperator(){
        client = new AsyncHttpClient();
    }

    public void get(String url){


        client.get(url, new BaseJsonHttpResponseHandler<JSONObject>() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, JSONObject response) {
                httpResponse(rawJsonResponse, SUCCESS);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, JSONObject errorResponse) {
                httpResponse(rawJsonData, FAIL);
            }

            @Override
            protected JSONObject parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                return null;
            }

        });
    }

    protected abstract void httpResponse(String rawJson, String response);
}
