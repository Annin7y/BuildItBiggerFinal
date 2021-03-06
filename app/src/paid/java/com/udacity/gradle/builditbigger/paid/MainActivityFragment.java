package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.udacity.gradle.builditbigger.BaseMainActivityFragment;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

import builditbigger.android.my.annin.jokeslibrary.JokesActivity;

public class MainActivityFragment extends BaseMainActivityFragment
{
    //Main Activity Fragment copied from main directory; AdView code removed
    public MainActivityFragment()
    {
    }

    TextView helloStringPaid;

    private Button jokeButton;

    private ProgressBar indicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        helloStringPaid = (TextView)root.findViewById(R.id.hello_paid_text_view);

        // Initialize the loading indicator
        indicator = (ProgressBar) root.findViewById(R.id.my_loading_indicator);

        jokeButton = (Button) root.findViewById(R.id.joke_button);

        jokeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // do something
                tellJoke();

            }
        });



        return root;
    }

    @Override
    public void tellJoke()
    {

        // Show the loading indicator before running the AsyncTask
        indicator.setVisibility(ProgressBar.VISIBLE);

        EndpointsAsyncTask myTask = new EndpointsAsyncTask(this);
        myTask.execute();
    }

    @Override
    public void returnJokeData(String result)
    {
        // Hide it after it finishes
        indicator.setVisibility(ProgressBar.INVISIBLE);

        Intent intent = new Intent(getActivity(), JokesActivity.class);
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(JokesActivity.JOKE_STRING, result);
        startActivity(intent);


    }

    }
