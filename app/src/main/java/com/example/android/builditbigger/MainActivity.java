package com.example.android.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import builditbigger.android.example.com.androidjokes.JokesActivity;

public class MainActivity extends AppCompatActivity {
    protected ProgressBar spinner;

    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar) this.findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public void launchLibraryActivity(View view) {
        final Context context = this;
        spinner.setVisibility(View.VISIBLE);
        (new EndpointsAsyncTask(
                new EndpointsAsyncTask.AsyncResponse(){

                    @Override
                    public void processFinish(String output){
                        //Here you will receive the result fired from async class
                        //of onPostExecute(result) method.
                        Intent myIntent = new Intent(context, JokesActivity.class);
                        myIntent.putExtra("hilarious guitar joke", output);
                        startActivity(myIntent);
                        spinner.setVisibility(View.GONE);
                        requestNewInterstitial();
                    }
                }
        )).execute(new Pair<Context, String>(this, "Manfred"));
    }


}
