package com.example.lardman.mandatoryassignmentv1;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        final ListView listView = view.findViewById(R.id.fragmentBirdObservationListView);

        return view;
    }

    //TODO:Appen crasher når den har ReadTask på, kan være mangel på adapter? not sure

    //TODO: fix denne metode
    //TODO: skal have liste fra birdListItemAdapter.. se bookstore main
    @Override
    public void onStart()
    {
        super.onStart();
        ReadTask task = new ReadTask();
        task.execute("http://anbo-restserviceproviderbooks.azurewebsites.net/Service1.svc/books");
    }


    //TODO: skulle gerne være iorden.. kig her hvis der er problemer
    private class ReadTask extends ReadHttpTask
    {

        @Override
        protected void onPostExecute(CharSequence jsonString)
        {
            Gson gson = new GsonBuilder().create();
            final Bird[] birds = gson.fromJson(jsonString.toString(), Bird[].class);

            ListView listView = getActivity().findViewById(R.id.fragmentBirdObservationListView);
            BirdListItemAdapter adapter = new BirdListItemAdapter(getActivity(), R.layout.birdlist_item, birds);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Intent intent = new Intent(getActivity(), SpecificBirdActivity.class);
                    Bird bird = birds[(int) id];
                    intent.putExtra("BIRD", bird);
                    startActivity(intent);
                }
            });
        }


        @Override
        protected void onCancelled(CharSequence message) {
            TextView messageTextView = getActivity().findViewById(R.id.fragmentBird_Message_TextView);
            messageTextView.setText(message);
            Log.e("BIRDS", message.toString());
        }
    }

}
