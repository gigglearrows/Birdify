package com.appandgo.birdify;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BirdListAdapter extends ArrayAdapter<Bird> {

    private final Activity context;
    private final int layoutId;
    private Bird data[] = null;

    public BirdListAdapter(Activity context, int layoutId, Bird[] data) {
        super(context, layoutId, data);

        this.context = context;
        this.layoutId = layoutId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        BirdHolder holder;

        if (row == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            row = inflater.inflate(layoutId, parent, false);

            holder = new BirdHolder();
            holder.birdIcon = (ImageView) row.findViewById(R.id.birdicon);
            holder.birdName = (TextView) row.findViewById(R.id.birdname);
            row.setTag(holder);
        } else {
            holder = (BirdHolder) row.getTag();
        }

        Bird bird = data[position];
        holder.birdName.setText(bird.name);
        holder.birdIcon.setImageResource(bird.image);

        return row;
    }

    private static class BirdHolder {
        ImageView birdIcon;
        TextView birdName;
    }
}