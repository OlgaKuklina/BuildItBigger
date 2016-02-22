package builditbigger.android.example.com.androidjokes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JokesActivity extends AppCompatActivity implements JokesActivityFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
    }

    public void launchLibraryActivity(View view){
        Intent myIntent = new Intent(this, JokesActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
