package com.example.lardman.mandatoryassignmentv1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class fragment_bird_list extends Fragment
{
    public fragment_bird_list()
    {
        //Empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.activity_fragment_bird_list, container, false);

        final ListView listView = view.findViewById(R.id.mainMenuBirdObservationListView);

        return view;
    }

    //TODO: fix denne metode
    @Override
    public void onStart()
    {
        super.onStart();
        ReadTask task = new ReadTask();
        task.execute("http://anbo-restserviceproviderbooks.azurewebsites.net/Service1.svc/books");
    }

}
