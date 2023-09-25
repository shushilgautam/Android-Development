package com.example.projectone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {
    Button bca,csit,mainPage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthpage);
        bca=findViewById(R.id.bca);
        csit=findViewById(R.id.csit);
        mainPage=findViewById(R.id.mainPage);
        bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FourthActivity.this,FifthActivity.class);
                startActivity(i);
            }
        });
        csit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(FourthActivity.this,SixthActivity.class);
                startActivity(j);
            }
        });
        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k= new Intent(FourthActivity.this,FirstActivity.class);
                startActivity(k);
            }
        });
    }
}
