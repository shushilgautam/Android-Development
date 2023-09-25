package com.example.azonix;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    TextView tv;
    Button add, sub;
    int counter=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_ui);
        tv = findViewById(R.id.result);
        add = findViewById(R.id.btnAdd);
        sub = findViewById(R.id.btnSub);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic for add
                counter++;
                tv.setText("" + counter);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic for sub
                counter--;
                tv.setText("" + counter);
            }
        });

    }
}
