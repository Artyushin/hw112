package com.artyushin.hw112;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private List<Information> data;

    public CustomAdapter(List<Information> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView!=null){
            view = convertView;
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        TextView titleText = (TextView) view.findViewById(R.id.title);
        TextView subtitleText = (TextView) view.findViewById(R.id.subtitle);
        Button button = (Button) view.findViewById(R.id.button);

        Information informatoin = data.get(position);

        imageView.setImageResource(informatoin.getImgId());
        titleText.setText(informatoin.getMainTitle());
        subtitleText.setText(informatoin.getSubTitle());
        button.setText(informatoin.getNameButton());
        button.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                data.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
