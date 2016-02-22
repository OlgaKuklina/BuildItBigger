package builditbigger.android.example.com.androidjokes;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */

public class JokesActivityFragment extends Fragment {


        public JokesActivityFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_jokes_activity, container, false);
        }
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            String joke = getActivity().getIntent().getExtras().getString("hilarious guitar joke");
            TextView jokeView = (TextView) view.findViewById(R.id.libraryWelcomeTextView);
            jokeView.setText(joke);
        }
    }