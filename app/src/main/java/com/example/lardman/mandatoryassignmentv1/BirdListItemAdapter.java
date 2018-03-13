package com.example.lardman.mandatoryassignmentv1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import java.util.List;

/**
 * Created by Lardman on 13-03-2018.
 */

public class BirdListItemAdapter extends ArrayAdapter<Bird>
{
    private final int resource;

    public BirdListItemAdapter(Context context, int resource, List<Bird> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    public BirdListItemAdapter(Context context, int resource, Bird[] objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Bird bird = getItem(position);
        String title = bird.getTitle();
        String author = bird.getAuthor();
        LinearLayout bookView;
        if (convertView == null) {
            bookView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, bookView, true);
        } else {
            bookView = (LinearLayout) convertView;
        }
        TextView titleView = bookView.findViewById(R.id.booklist_item_title);
        TextView authorView = bookView.findViewById(R.id.booklist_item_author);
        titleView.setText(title);
        authorView.setText(" by " + author);
        return bookView;
    }
}