package com.udacity.gradle.builditbigger.paid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udacity.gradle.builditbigger.R;

public class MainActivityFragment extends Fragment
{

    public MainActivityFragment()
    {
    }

    TextView helloStringPaid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        helloStringPaid = (TextView)root.findViewById(R.id.hello_paid_text_view);

        return root;
    }}