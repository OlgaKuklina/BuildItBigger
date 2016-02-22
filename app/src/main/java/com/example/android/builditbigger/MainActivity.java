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
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }


    public void launchLibraryActivity(View view){
        Intent myIntent = new Intent(this, JokesActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
