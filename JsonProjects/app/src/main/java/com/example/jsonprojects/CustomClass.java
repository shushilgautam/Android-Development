package com.example.jsonprojects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomClass extends BaseAdapter {
    Context c;
    ArrayList<DataModel> data;
    public CustomClass(FirstActivity firstActivity, ArrayList<DataModel> list) {
        c=firstActivity;
        data=list;
    }

    @Override
    public int getCount() {
        return data.size();
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
        View myview= LayoutInflater.from(c).inflate(R.layout.singlelayout,null);
        TextView scrname=myview.findViewById(R.id.scrName);
        TextView scrid=myview.findViewById(R.id.scrid);
        TextView scrSubIdd=myview.findViewById(R.id.scrSubId);
        scrid.setText(""+data.get(i).id);
        scrname.setText(data.get(i).name);
        scrSubIdd.setText(""+data.get(i).subject_id);

        return myview;

    }
}
