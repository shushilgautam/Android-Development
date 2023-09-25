package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, min, pro, div, equal, dot, clr, off, del;
    TextView result;
    int counter = 0;
    double temp1,temp2;
    double equals;
    int statusAdd,statusMin,statusMul,statusDiv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        zero = findViewById(R.id.btn0);
        plus = findViewById(R.id.btnPlus);
        min = findViewById(R.id.btnMin);
        pro = findViewById(R.id.btnMul);
        div = findViewById(R.id.btnDiv);
        equal = findViewById(R.id.btnEqual);
        dot = findViewById(R.id.btnDot);
        del = findViewById(R.id.btnDel);
        off = findViewById(R.id.btnOff);
        clr = findViewById(R.id.btnClr);
        result = findViewById(R.id.result);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "5");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText().toString() + "0");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter == 0) {
                    result.setText(result.getText().toString() + ".");
                    counter++;
                }
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                result.setText("");
                counter=0;
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                temp1=Double.parseDouble(result.getText().toString());
                result.setText("");
                statusAdd=1;
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                temp1=Double.parseDouble(result.getText().toString());
                result.setText("");
                statusMin=1;
            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                temp1=Double.parseDouble(result.getText().toString());
                result.setText("");
                statusMul=1;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                temp1=Double.parseDouble(result.getText().toString());
                result.setText("");
                statusDiv=1;
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                temp2=Double.parseDouble(result.getText().toString());
                if(statusAdd==1) {
                    equals = temp1 + temp2;
                    result.setText("" + equals);
                    statusAdd=0;
                }
                if(statusMin==1) {
                    equals = temp1 - temp2;
                    result.setText("" + equals);
                    statusMin=0;
                }
                if(statusMul==1) {
                    equals = temp1 * temp2;
                    result.setText("" + equals);
                    statusMul=0;
                }
                if(statusDiv==1) {
                    equals = temp1 / temp2;
                    result.setText("" + equals);
                    statusDiv = 0;
                }}
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstActivity.this.finish();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=result.getText().toString();
                s=s.substring(0,s.length()-1);
                result.setText(s);
            }
        });


    }


}
