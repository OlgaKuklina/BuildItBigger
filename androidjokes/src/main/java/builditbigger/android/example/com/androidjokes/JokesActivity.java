package builditbigger.android.example.com.androidjokes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Intent intent = getIntent();
        String joke = intent.getStringExtra("hilarious guitar joke");
        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();

    }

    public void launchLibraryActivity(View view){
        Intent myIntent = new Intent(this, JokesActivity.class);
        startActivity(myIntent);


    }

}
