package com.example.android.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import builditbigger.android.example.com.androidjokes.JokesActivity;

public class MainActivity extends AppCompatActivity implements FragmentMain.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
    public void launchLibraryActivity(View view) {
        final Context context = this;
        (new EndpointsAsyncTask(
                new EndpointsAsyncTask.AsyncResponse(){

                    @Override
                    public void processFinish(String output){
                        //Here you will receive the result fired from async class
                        //of onPostExecute(result) method.
                        Intent myIntent = new Intent(context, JokesActivity.class);
                        myIntent.putExtra("hilarious guitar joke", output);
                        startActivity(myIntent);
                    }
                }
        )).execute(new Pair<Context, String>(this, "Manfred"));
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
