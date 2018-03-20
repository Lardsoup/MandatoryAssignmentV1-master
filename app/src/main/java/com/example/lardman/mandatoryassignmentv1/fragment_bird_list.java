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
    public View view;

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
        view =  inflater.inflate(R.layout.activity_fragment_bird_list, container, false);

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

    //TODO: der er noget galt her, findViewById tilhører AppCompatActivity, find ud af hvornår / hvordan du henter den her liste
    private class ReadTask extends ReadHttpTask
    {

        @Override
        protected void onPostExecute(CharSequence jsonString)
        {
            /*
            final List<Book> books = new ArrayList<>();
            try {
                JSONArray array = new JSONArray(jsonString.toString());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    String author = obj.getString("Author");
                    double price = obj.getDouble("Price");
                    String title = obj.getString("Title");
                    String publisher = obj.getString("Publisher");
                    int id = obj.getInt("Id");
                    Book book = new Book(id, author, title, publisher, price);
                    books.add(book);
                }
                */
            Gson gson = new GsonBuilder().create();
            final Bird[] birds = gson.fromJson(jsonString.toString(), Bird[].class);

            ListView listView = view.findViewById(R.id.mainMenuBirdObservationListView);
            //ArrayAdapter<Book> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, books);
            BirdListItemAdapter adapter = new BirdListItemAdapter(getActivity(), R.layout.birdlist_item, birds);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), BookActivity.class);
                    //Book book = books.get((int) id);
                    Bird bird = birds[(int) id];
                    intent.putExtra("BIRD", bird);
                    startActivity(intent);
                }
            });
           /* } catch (JSONException ex) {
                messageTextView.setText(ex.getMessage());
                Log.e("BOOKS", ex.getMessage());
            }*/
        }


        @Override
        protected void onCancelled(CharSequence message) {
            TextView messageTextView = findViewById(R.id.main_message_textview);
            messageTextView.setText(message);
            Log.e("BOOKS", message.toString());
        }
    }

}
//TODO: sæt scrollview over listen i XML delen så man kan scolle listen
