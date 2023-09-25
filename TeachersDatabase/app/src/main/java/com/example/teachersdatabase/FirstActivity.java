package com.example.teachersdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {
    Button btnAdd;
    TextView count;
    ListView list;
    ArrayList<DataModel> data= new ArrayList<>();
    Spinner spin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);
        btnAdd=findViewById(R.id.btnAdd);
        count=findViewById(R.id.count);
        list=findViewById(R.id.list);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] sem = { "First Sem", "Second Sem", "Third Sem", "Fourth Sem", "Fifth Sem",
                        "Sixth Sem", "Seventh Sem", "Eighth Sem"};
                AlertDialog.Builder builder=new AlertDialog.Builder(FirstActivity.this);
                View viewAdd= LayoutInflater.from(FirstActivity.this).inflate(R.layout.add_data,null);
                spin = (Spinner) viewAdd.findViewById(R.id.addSem);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(FirstActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.SemesterList));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin.setAdapter(adapter);
                builder.setView(viewAdd);
                AlertDialog alert=builder.create();
                alert.show();
                EditText name=viewAdd.findViewById(R.id.addName);
                EditText subject=viewAdd.findViewById(R.id.addSubject);
                Button save=viewAdd.findViewById(R.id.btnSave);
                Button cancel=viewAdd.findViewById(R.id.btnCancel);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DataModel d=new DataModel();
                        d.name=name.getText().toString();
                        d.subject=subject.getText().toString();
                        d.semester=spin.getSelectedItem().toString();//spinner problem
                        DatabaseHelper help=new DatabaseHelper(FirstActivity.this);
                        help.insertData(d);
                        alert.dismiss();
                        Intent i= new Intent(FirstActivity.this,FirstActivity.class);
                        startActivity(i);

                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alert.dismiss();

                    }
                });

            }
        });
        DatabaseHelper help=new DatabaseHelper(FirstActivity.this);
        data=help.readData();
        count.setText("Teachers Count ="+data.size());
        list.setAdapter(new CustomClass(FirstActivity.this,data));

    }

}
