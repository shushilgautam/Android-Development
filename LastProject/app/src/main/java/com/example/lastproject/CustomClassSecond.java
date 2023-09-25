package com.example.lastproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomClassSecond extends BaseAdapter {
    Context c;
    ArrayList<DataModelSecond> data;
    public CustomClassSecond(SubSubjectList subSubjectList, ArrayList<DataModelSecond> model) {
        c=subSubjectList;
        data=model;
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
        View myview = LayoutInflater.from(c).inflate(R.layout.singlelayoutsecond,null);
        TextView scrName=myview.findViewById(R.id.screenName);
        TextView scrId=myview.findViewById(R.id.screenId);
        TextView scrSubId=myview.findViewById(R.id.screenSubId);
        scrId.setText("Id : "+data.get(i).id);
        scrSubId.setText("Subject Id : "+data.get(i).subId);
        scrName.setText(data.get(i).name);
        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii= new Intent(c, PdfViewer.class);
                ii.putExtra("id", ""+data.get(i).id);
                ii.putExtra("Sub_id",data.get(i).subId);
                c.startActivity(ii);
            }
        });
        return myview;
    }
}
