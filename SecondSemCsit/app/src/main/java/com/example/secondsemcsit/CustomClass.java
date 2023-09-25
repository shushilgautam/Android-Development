package com.example.secondsemcsit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class CustomClass extends BaseAdapter {
    String[] data,location,phoneno;
    Context c;
    public CustomClass(FirstActivity firstActivity, String[] names, String[] address, String[] phone) {
        data=names;
        c=firstActivity;
        location=address;
        phoneno=phone;
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
        TextView nameScreen=myview.findViewById(R.id.nameScr);
        nameScreen.setText(data[i]);
        TextView addressScreen=myview.findViewById(R.id.AddressScr);
        addressScreen.setText(location[i]);
        TextView phoneScreen=myview.findViewById(R.id.phoneScr);
        phoneScreen.setText(phoneno[i]);
        return myview;

    }
}
