package com.example.teachersdatabase;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.Random;

public class CustomClass extends BaseAdapter {
    Context c;
    ArrayList<DataModel> dataList;
    String colorVar;
    int num;
    public CustomClass(FirstActivity firstActivity, ArrayList<DataModel> data) {
        c=firstActivity;
        dataList=data;
    }

    @Override
    public int getCount() {
        return dataList.size();
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
        View listUi= LayoutInflater.from(c).inflate(R.layout.singlelayout,null);
        ImageView teacher=listUi.findViewById(R.id.teacher_photo);
        TextView scrId=listUi.findViewById(R.id.screenid);
        TextView scrName=listUi.findViewById(R.id.screenName);
        TextView scrSubject=listUi.findViewById(R.id.screensub);
        TextView scrSemester=listUi.findViewById(R.id.screenSemster);
        scrId.setText(""+dataList.get(i).id);
        scrName.setText(dataList.get(i).name);
        scrSubject.setText(dataList.get(i).subject);
        scrSemester.setText(dataList.get(i).semester);
        Random rand= new Random();
        num=rand.nextInt(5);
        if(num==1)
            teacher.setBackgroundResource(R.drawable.backgroundteacher);
        else if (num ==2)
            teacher.setBackgroundResource(R.drawable.teacher2);
        else if (num ==3)
            teacher.setBackgroundResource(R.drawable.teacher3);
        else if (num ==4)
            teacher.setBackgroundResource(R.drawable.teacher4);
        else
            teacher.setBackgroundResource(R.drawable.teacher5);
        listUi.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(c);
                View editView=LayoutInflater.from(c).inflate(R.layout.edit_data,null);
                builder.setView(editView);
                EditText editName=editView.findViewById(R.id.editName);
                EditText editSubject=editView.findViewById(R.id.editSubject);
                Spinner editSem=editView.findViewById(R.id.editSem);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(c, android.R.layout.simple_spinner_item,c.getResources().getStringArray(R.array.SemesterList));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                editSem.setAdapter(adapter);
                Button btnEdit=editView.findViewById(R.id.btnEdit);
                Button btnDel=editView.findViewById(R.id.btnDelete);
                editName.setText(dataList.get(i).name);
                editSubject.setText(dataList.get(i).subject);
//                editSem.setText(dataList.get(i).semester);
//                editSem.setSelection(dataList.get(i).semester);
                AlertDialog alert=builder.create();
                alert.show();
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DataModel d=new DataModel();
                        d.id=dataList.get(i).id;
                        d.name=editName.getText().toString();
                        d.subject=editSubject.getText().toString();
                        d.semester=editSem.getSelectedItem().toString();
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
                        drop.deletaData(dataList.get(i).id);
                        Intent i=new Intent(c,FirstActivity.class);
                        alert.dismiss();
                        c.startActivity(i);
                    }
                });

                return true;
            }
        });
        return listUi;
    }
}
