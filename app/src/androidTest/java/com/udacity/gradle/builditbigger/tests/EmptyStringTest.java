package com.udacity.gradle.builditbigger.tests;


import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.EndpointsAsyncTaskInterface;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EmptyStringTest
{

    //The code for the test is based on the following:
    //https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework/5722193#5722193
    //https://gist.github.com/he9lin/2195897

    @Test
    public void testAsyncTask() throws Throwable
    {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);

        final EndpointsAsyncTaskInterface myTaskInterface = new EndpointsAsyncTaskInterface()
        {
            @Override
            public void returnJokeData(String result)
            {
                assertNotNull(result);
                signal.countDown();
            }
        };
        new EndpointsAsyncTask(myTaskInterface).execute();
        signal.await(30, TimeUnit.SECONDS);
    }
}
