package com.example.sqlite1818080;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Kamera> movieItems;

    public CustomListAdapter(Activity activity, List<Kamera> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView merk = (TextView) convertView.findViewById(R.id.text_merk);
        TextView tipe = (TextView) convertView.findViewById(R.id.text_tipe);
        TextView status = (TextView) convertView.findViewById(R.id.text_status);

        Kamera t = movieItems.get(position);
        merk.setText("Merk Kamera : "+ t.get_merk());
        tipe.setText("Tipe                 : "+ t.get_tipe());
        status.setText("Status              : "+ t.get_status());
        return convertView;
    }

}
