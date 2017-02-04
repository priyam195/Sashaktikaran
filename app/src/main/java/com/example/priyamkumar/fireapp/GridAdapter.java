package com.example.priyamkumar.fireapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Priyam Kumar on 2/4/2017.
 */

public class GridAdapter extends BaseAdapter {
    Context ctx;

    ArrayList<Grid> data;

    public GridAdapter(Context c, ArrayList<Grid> d) {
        ctx = c;
        data = d;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        // TODO Auto-generated method stub

        if (arg1 == null) {
            LayoutInflater lf = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            arg1 = lf.inflate(R.layout.cust, arg2, false);

        }

        ImageView iv = (ImageView) arg1.findViewById(R.id.customGridImageView);
        TextView tv = (TextView) arg1.findViewById(R.id.customGridView);
        Grid g = data.get(arg0);
        tv.setText(g.title);
        tv.setTextColor(Color.parseColor(g.color));
        iv.setImageResource(g.image);

        return arg1;
    }
}