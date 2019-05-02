package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.BaseMainActivityFragment;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

import builditbigger.android.my.annin.jokeslibrary.JokesActivity;

public class MainActivityFragment extends BaseMainActivityFragment
{
    //Main Activity Fragment copied from main directory
    public MainActivityFragment()
    {
    }

    TextView helloStringFree;

    private InterstitialAd interstitialAd;

    private Button jokeButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        helloStringFree = (TextView) root.findViewById(R.id.hello_free_text_view);

        jokeButton = (Button)getView().findViewById(R.id.joke_button);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(getActivity(), "ca-app-pub-4761500786576152~8215465788");
        interstitialAd = new InterstitialAd(getActivity().getApplicationContext());
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        interstitialAd.setAdListener(new AdListener()
        {
            public void onAdLoaded()
            {
                if (interstitialAd.isLoaded())
                {
                    interstitialAd.show();

                }


            }
            @Override
            public void onAdClosed() {
                super.onAdClosed();

            }
        });
        return root;

        }
@Override
    public void tellJoke(View view)
    {
        // JokesFetch myJokesFetch = new JokesFetch();

        // default code below replaced with the code referencing JokesLibrary
        // Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
        // Message commented out after adding JokesActivity class
        // Toast.makeText(this, myJokesFetch.getRandomJoke(), Toast.LENGTH_SHORT).show();

        // Code structure below is based on the answer given on this site:
        // https://www.c-sharpcorner.com/article/how-to-send-the-data-one-activity-to-another-activity-in-android-application/
        // Code commented out after implementing GCE
//        Intent intent = new Intent(this, JokesActivity.class);
//        intent.setAction(Intent.ACTION_SEND);
//        intent.putExtra(JOKE_STRING, myJokesFetch.getRandomJoke());
//        startActivity(intent);

         EndpointsAsyncTask myTask = new EndpointsAsyncTask(this);
         myTask.execute();
    }

    @Override
    public void returnJokeData(String result)
    {
        Intent intent = new Intent(getActivity(), JokesActivity.class);
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(JokesActivity.JOKE_STRING, result);
        startActivity(intent);
    }



}
