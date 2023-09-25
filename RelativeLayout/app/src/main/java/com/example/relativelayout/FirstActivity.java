package com.example.relativelayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    ListView list;
//    String[] names={"Shushil","Samrat","Rudra","Rishab","Samir","Rohan","Sangit","Suprim","nisan",
//            "Samsung","Shushil","Samrat","Rudra","Rishab","Samir","Rohan","Shushil","Samrat","Rudra"
//            ,"Rishab","Samir","Rohan"};
String[] names={"Shushil","Samrat","Rudra"};
String[] address={"nepal","india","finland"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);
        list=findViewById(R.id.list);
//        list.setAdapter(new ArrayAdapter<String>
//                (FirstActivity.this, android.R.layout.simple_list_item_1,names));
            list.setAdapter(new CustomClass(FirstActivity.this,names,address));

    }
}
