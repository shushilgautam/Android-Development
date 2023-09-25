package com.example.fullcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, min, pro, div, equal, dot, clr, off, del,plusMinus;
    TextView result;
    int counter = 0;
    int opAdd=0,opSub=0,opMul=0,opDiv=0;
    double firstValue,secondValue,total;
    boolean statusAdd,statusSub,statusMul,statusDiv;
    String starting;
    boolean plusStatus=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_home);
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
        equal = findViewById(R.id.btnEquals);
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
                result.setText(result.getText().toString() + "4");
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

                    result.setText( result.getText().toString()+ "0");
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
                opAdd=0;
                opSub=0;
                opDiv=0;
                opMul=0;
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(!result.getText().toString().equals("")) {
                    opAdd++;
                    if (opAdd > 1) {
                        firstValue = firstValue + Double.parseDouble(result.getText().toString());
                    } else {
                        firstValue = Double.parseDouble(result.getText().toString());
                    }
                    result.setText("");

                    statusAdd = true;
                    counter = 0;
                }
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(!result.getText().toString().equals("")) {
                    opSub++;
                    if (opSub > 1) {
                        firstValue = firstValue - Double.parseDouble(result.getText().toString());
                    } else {
                        firstValue = Double.parseDouble(result.getText().toString());
                    }
                    result.setText("");
                    statusSub = true;
                    counter = 0;
                }
            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(!result.getText().toString().equals("")) {
                opMul++;
                if(opMul>1){
                    firstValue=firstValue*Double.parseDouble(result.getText().toString());
                }
                else {
                    firstValue = Double.parseDouble(result.getText().toString());
                }
                result.setText("");
                statusMul=true;
                counter=0;
            }}
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                    if(!result.getText().toString().equals("")) {
                        opDiv++;
                        if (opDiv > 1) {
                            firstValue = firstValue / Double.parseDouble(result.getText().toString());
                        } else {
                            firstValue = Double.parseDouble(result.getText().toString());
                        }
                        result.setText("");
                        statusDiv = true;
                        counter = 0;
                    }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!result.getText().toString().equals("")) {
                    secondValue = Double.parseDouble(result.getText().toString());
                    if (statusAdd) {
                        total = firstValue + secondValue;
                        result.setText("" + total);
                        statusAdd = false;
                    }
                    if (statusSub) {
                        total = firstValue - secondValue;
                        result.setText("" + total);
                        statusSub = false;
                    }
                    if (statusMul) {
                        total = firstValue * secondValue;
                        result.setText("" + total);
                        statusMul = false;
                    }
                    if (statusDiv) {
                        total = firstValue / secondValue;
                        result.setText("" + total);
                        statusDiv = false;
                    }
                }
            }
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
                if(!result.getText().toString().equals("")) {
                    String s = result.getText().toString();
                    s = s.substring(0, s.length() - 1);
                    result.setText(s);
                }
            }
        });



    }


}