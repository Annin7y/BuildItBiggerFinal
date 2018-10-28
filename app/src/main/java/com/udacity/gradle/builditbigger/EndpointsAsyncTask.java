package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.net.URL;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String>
{
    //Code imported from: https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/deprecation/HelloEndpoints
    //Some original code commented out

    private static MyApi myApiService = null;
   // private Context context;

    private static final String TAG = EndpointsAsyncTaskInterface.class.getSimpleName();
    private EndpointsAsyncTaskInterface listener;

    public EndpointsAsyncTask(EndpointsAsyncTaskInterface listener)
    {
        this.listener = listener;
    }

        @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void ... params)
    {
        if(myApiService == null)
        {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer()
                    {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException
                        {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

       // context = params[0];
       // String name = params[0].second;
        
        try
        {
            return myApiService.getJokeFromRepository().execute().getData();
        }
        catch (IOException e)
        {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result)
    {
       // Toast.makeText(context,result, Toast.LENGTH_LONG).show();
        super.onPostExecute(result);

        if (result != null)
        {
            listener.returnJokeData(result);
        }
    }
}


