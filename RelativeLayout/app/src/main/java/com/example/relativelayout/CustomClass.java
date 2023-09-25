package com.example.relativelayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class CustomClass extends BaseAdapter {
    String[] data,add;
    Context c;
    public CustomClass(FirstActivity firstActivity, String[] names,String[] address) {
        data=names;
        c=firstActivity;
        add=address;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View myview= LayoutInflater.from(c).inflate(R.layout.myview,null);
        TextView screen=myview.findViewById(R.id.myScreen);
        screen.setText(data[i]);
        TextView screen2=myview.findViewById(R.id.myScreen2);
        screen2.setText(add[i]);
        return myview;
    }

}
