package com.udacity.gradle.builditbigger.tests;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.EndpointsAsyncTaskInterface;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EmptyStringTest {

    //The code for the test is based on the following:
    //https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework/5722193#5722193
    //https://gist.github.com/he9lin/2195897

    public void testAsyncTask () throws Throwable {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);

        final EndpointsAsyncTask myTask = new EndpointsAsyncTask();

            @Override
            protected String doInBackground(Void... params) {
                //Do something meaningful.
                return "something happened!";
            }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            /* This is the key, normally you would use some type of listener
             * to notify your activity that the async call was finished.
             *
             * In your test method you would subscribe to that and signal
             * from there instead.
             */

            signal.countDown();
        }
    };



    ;
// Execute the async task on the UI thread! THIS IS KEY!
        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                myTask.execute();
            }
        });

        signal.await(30, TimeUnit.SECONDS);
        assertTrue();

    }
    }
