package com.udacity.gradle.builditbigger.tests;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.EndpointsAsyncTaskInterface;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EmptyStringTest {

    //The code for the test is based on the following stackoverflow post:
    //https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework/5722193#5722193

    public void testAsynTask () throws Throwable {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);

    }

        // create  a signal to let us know when our task is done.


    @Test
    public void method() {

        // Run your AsyncTask
        // Use the Assert methods to verify the data

    }


}
