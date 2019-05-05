package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import builditbigger.android.my.annin.jokeslibrary.JokesActivity;

public class BaseMainActivityFragment extends Fragment implements EndpointsAsyncTaskInterface
{
    public static final String JOKE_STRING = "joke_string";

   @Override
    public void returnJokeData(String result)
    {
        Intent intent = new Intent(getActivity(), JokesActivity.class);
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(JokesActivity.JOKE_STRING, result);
        startActivity(intent);
    }

    public void tellJoke()
    {
    }
   }

