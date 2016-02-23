package com.example.android.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;

import com.example.olgakuklina.builditbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by olgakuklina on 2016-02-21.
 */
class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {


    // you may separate this or combined to caller class.
    public interface AsyncResponse {
        void processFinish(String output);
    }


    private static MyApi myApiService = null;
    private Context context;
    public AsyncResponse delegate = null;


    public EndpointsAsyncTask(AsyncResponse delegate){
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1229.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //  Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        delegate.processFinish(result);

    }
}
