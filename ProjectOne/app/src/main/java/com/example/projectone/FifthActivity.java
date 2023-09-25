package com.example.projectone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FifthActivity extends AppCompatActivity {
    Button syllabus,mainPage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifthpage);
        syllabus=findViewById(R.id.syllabus);
        mainPage=findViewById(R.id.mainPage);
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(FifthActivity.this,FourthActivity.class);
                startActivity(i);
            }
        });
        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(FifthActivity.this,FirstActivity.class);
                startActivity(j);
            }
        });
    }
}
