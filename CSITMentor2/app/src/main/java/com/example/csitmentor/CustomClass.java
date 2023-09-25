package com.example.csitmentor;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class CustomClass extends BaseAdapter {
    Context c;
    ArrayList<DataModel> datalist;
    public CustomClass(Context context, ArrayList<DataModel> data) {
        c=context;
        datalist=data;

    }

    @Override
    public int getCount() {
        return datalist.size();
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
        View listUi= LayoutInflater.from(c).inflate(R.layout.custom_listview,null);
        TextView sub_name=listUi.findViewById(R.id.subName);
        TextView sub_id=listUi.findViewById(R.id.subId);
        TextView id=listUi.findViewById(R.id.id);
        sub_name.setText(datalist.get(i).sub_name);
        sub_id.setText(datalist.get(i).sub_id);
        id.setText(datalist.get(i).id);
        listUi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=sub_name.getText().toString();
                String id=sub_id.getText().toString();
                Intent intent=new Intent(c,SubjectActivity.class);
                intent.putExtra("subName",name);
                intent.putExtra("subId",id);
                c.startActivity(intent);
            }
        });
        return listUi;
    }
}
