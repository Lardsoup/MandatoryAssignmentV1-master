package com.example.lardman.mandatoryassignmentv1;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Lardman on 13-03-2018.
 */

//TODO: kig på den her class og find ud af hvad den laver og om det passer til dit program
public class ReadTask extends ReadHttpTask
{

    @Override
    protected void onPostExecute(CharSequence jsonString) {
        TextView messageTextView = findViewById(R.id.main_message_textview);
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
        final Book[] books = gson.fromJson(jsonString.toString(), Book[].class);

        ListView listView = findViewById(R.id.main_books_listview);
        //ArrayAdapter<Book> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, books);
        BookListItemAdapter adapter = new BookListItemAdapter(getBaseContext(), R.layout.booklist_item, books);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), BookActivity.class);
                //Book book = books.get((int) id);
                Book book = books[(int) id];
                intent.putExtra("BOOK", book);
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
