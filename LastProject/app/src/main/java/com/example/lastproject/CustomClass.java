package com.example.lastproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class CustomClass extends BaseAdapter {
    Context c;
    ArrayList<DataModel> data;
    public CustomClass(SubjectList subjectList, ArrayList<DataModel> model) {
        data=model;
        c=subjectList;
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
        View myview = LayoutInflater.from(c).inflate(R.layout.singlelayout,null);
        TextView scrName=myview.findViewById(R.id.screenName);
        TextView scrId=myview.findViewById(R.id.screenId);
        scrId.setText(""+data.get(i).id);
        scrName.setText(data.get(i).name);
        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii= new Intent(c, SubjectType.class);
                ii.putExtra("id", ""+data.get(i).id);
                c.startActivity(ii);

            }
        });
        return myview;
    }
}
