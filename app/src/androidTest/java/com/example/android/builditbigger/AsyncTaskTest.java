package com.example.android.builditbigger;
import android.content.Context;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.util.Pair;
/**
 * Created by olgakuklina on 2016-02-21.
 */
import java.util.concurrent.TimeUnit;

public class AsyncTaskTest extends AndroidTestCase {

    public void testSomething() throws Exception {
            String jokeText = null;
            EndpointsAsyncTask getJokeTask = new EndpointsAsyncTask(
                    new EndpointsAsyncTask.AsyncResponse(){

                        @Override
                        public void processFinish(String output){

                        }
                    }
            );
            getJokeTask.execute(new Pair<Context, String>(new MockContext(), "Manfred"));
            jokeText = getJokeTask.get(30, TimeUnit.SECONDS);
            assertNotNull(jokeText);
        }

}