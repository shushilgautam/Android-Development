package com.example.secondsemcsit;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    ListView listView;
    String[] names={"Shushil","Rishav","Subash","Rohan","Supreme","Saurav","Samir","Sangit","Pratik","Saurav","Shushil","Rishav","Subash","Rohan","Supreme","Saurav","Samir","Sangit","Pratik","Saurav"};
    String[] address={"Gulmi","Arghakhanchi","Ithari","Gulmi","Darchula",
            "Arghakhanchi","Okhaldhunga","Jhapa","Biratnagar","Bardiya","Gulmi","Arghakhanchi","Ithari","Gulmi","Darchula",
            "Arghakhanchi","Okhaldhunga","Jhapa","Biratnagar","Bardiya"};
    String[] phone={"9842675890","9828378264","9845673829","9849574839","9867574647",
            "9856545836","9844656489","981057750","9845678392","9822113452","9842675890","9828378264","9845673829","9849574839","9867574647",
            "9856545836","9844656489","981057750","9845678392","9822113452"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);
        listView=findViewById(R.id.list);
        listView.setAdapter(new CustomClass(FirstActivity.this,names,address,phone));
    }
}
