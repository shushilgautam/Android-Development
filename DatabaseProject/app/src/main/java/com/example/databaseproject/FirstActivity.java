package com.example.databaseproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {
    TextView count;
    Button btnadd;
    ListView list;
    ArrayList<DataModel> data=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
        count=findViewById(R.id.count);
        btnadd=findViewById(R.id.btnAdd);
        list=findViewById(R.id.list);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(FirstActivity.this);
                View v= LayoutInflater.from(FirstActivity.this).inflate(R.layout.add_data,null);
                builder.setView(v);
                AlertDialog alert=builder.create();
                alert.show();
                EditText name=v.findViewById(R.id.textName);
                EditText address=v.findViewById(R.id.textAddress);
                EditText phone= v.findViewById(R.id.textPhone);
                Button save=v.findViewById(R.id.btnSave);
                Button cancel =v.findViewById(R.id.btnCancel);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DataModel d=new DataModel();
                        d.name=name.getText().toString();
                        d.address=address.getText().toString();
                        d.phone=phone.getText().toString();
                        DatabaseHelper help=new DatabaseHelper(FirstActivity.this);
                        help.insertdata(d);
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
        count=findViewById(R.id.count);
        list=findViewById(R.id.list);
        DatabaseHelper display=new DatabaseHelper(FirstActivity.this);
        data=display.readdata();
        count.setText("Student Count ="+data.size());
        list.setAdapter(new Customclass(FirstActivity.this,data));

    }
}
