package com.example.databaseproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class Customclass extends BaseAdapter {
    ArrayList<DataModel> customData;
    Context c;
    public Customclass(FirstActivity firstActivity, ArrayList<DataModel> data) {
        customData=data;
        c=firstActivity;


    }

    @Override
    public int getCount() {
        return customData.size();
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
        TextView scrName=myview.findViewById(R.id.screenName);
        TextView scrAdd=myview.findViewById(R.id.screenAddress);
        TextView scrPhone=myview.findViewById(R.id.screenPhone);
        scrName.setText(customData.get(i).name);
        scrAdd.setText(customData.get(i).address);
        scrPhone.setText(customData.get(i).phone);
        myview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(c);
                View editView=LayoutInflater.from(c).inflate(R.layout.edit_data,null);
                builder.setView(editView);
                EditText editName=editView.findViewById(R.id.textName);
                EditText editAdd=editView.findViewById(R.id.textAddress);
                EditText editPhone=editView.findViewById(R.id.textPhone);
                Button btnEdit=editView.findViewById(R.id.btnEdit);
                Button btnDel=editView.findViewById(R.id.btnDelete);
                editName.setText(customData.get(i).name);
                editAdd.setText(customData.get(i).address);
                editPhone.setText(customData.get(i).phone);
                AlertDialog alert=builder.create();
                alert.show();
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DataModel d=new DataModel();
                        d.id=customData.get(i).id;
                        d.name=editName.getText().toString();
                        d.address=editAdd.getText().toString();
                        d.phone=editPhone.getText().toString();
                        DatabaseHelper helper=new DatabaseHelper(c);
                        helper.updatedata(d);
                        Intent i=new Intent(c,FirstActivity.class);
                        alert.dismiss();
                        c.startActivity(i);


                    }
                });
                btnDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatabaseHelper drop=new DatabaseHelper(c);
                        drop.deletaData(customData.get(i).id);
                        Intent i=new Intent(c,FirstActivity.class);
                        alert.dismiss();
                        c.startActivity(i);
                    }
                });

                return true;
            }
        });
        return myview;
    }
}
