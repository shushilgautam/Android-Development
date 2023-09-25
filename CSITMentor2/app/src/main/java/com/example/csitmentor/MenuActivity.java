package com.example.csitmentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MenuActivity extends AppCompatActivity {
    LinearLayout sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8,menubtn;
    String name;
    TextView username;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        username=findViewById(R.id.username);
        Intent intent=getIntent();
        name=intent.getStringExtra("intentName");
        username.setText("Hi "+name);
        sem1=findViewById(R.id.firstSem);
        sem2=findViewById(R.id.secondSem);
        sem3=findViewById(R.id.thirdSem);
        sem4=findViewById(R.id.fourthSem);
        sem5=findViewById(R.id.fifthSem);
        sem6=findViewById(R.id.sixthSem);
        sem7=findViewById(R.id.seventhSem);
        sem8=findViewById(R.id.eighthSem);
        loadFragment(new EighthSemFragment());
        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FirstSemFragment());
            }
        });
        sem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new SecondSemFragment());
            }
        });
        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ThirdSemFragment());
            }
        });
        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FourthSemFragment());
            }
        });
        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FifthSemFragment());
            }
        });
        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new SixthSemFragment());
            }
        });
        sem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new SeventhSemFragment());
            }
        });
        sem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new EighthSemFragment());
            }
        });


    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.fragmentView,fragment);
        ft.commit();
    }
}
