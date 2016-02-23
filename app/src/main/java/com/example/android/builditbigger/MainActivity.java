package com.example.android.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import builditbigger.android.example.com.androidjokes.JokesActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    protected ProgressBar spinner;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate " + savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar) this.findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                (new EndpointsAsyncTask(
                        new EndpointsAsyncTask.AsyncResponse(){

                            @Override
                            public void processFinish(String output){
                                //Here you will receive the result fired from async class
                                //of onPostExecute(result) method.
                                Intent myIntent = new Intent(MainActivity.this, JokesActivity.class);
                                myIntent.putExtra("hilarious guitar joke", output);
                                startActivity(myIntent);
                                spinner.setVisibility(View.GONE);

                            }
                        }
                )).execute(new Pair<Context, String>(MainActivity.this, "Manfred"));
            }
        });

        requestNewInterstitial();
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("948F454C97378483ACDCD4AF4824A690")
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
                    }
                }
        )).execute(new Pair<Context, String>(this, "Manfred"));
    }


    public void launchLibraryActivityWithAds(View view) {
        Log.d(TAG, "launchLibraryActivityWithAds ");
        spinner.setVisibility(View.VISIBLE);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }

    }

}
