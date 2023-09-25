package com.example.lastproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class FirstActivity extends AppCompatActivity {
    EditText name,email,phone,password;
    Button register,intentLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationlayout);
        name=findViewById(R.id.regName);
        email=findViewById(R.id.regEmail);
        phone=findViewById(R.id.regPhone);
        password=findViewById(R.id.regPassword);
        register=findViewById(R.id.register);
        intentLogin=findViewById(R.id.intentLogin);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || password.getText().toString().isEmpty()  ){
                    Toast.makeText(FirstActivity.this, "Field is empty", Toast.LENGTH_SHORT).show();
                }
                postDateUsingVolley(name.getText().toString(),email.getText().toString(),phone.getText().toString(),password.getText().toString());
            }
        });
        intentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent i= new Intent(FirstActivity.this,SignupActivity.class);
                 startActivity(i);
            }
        });

    }

    private void postDateUsingVolley(String name, String email, String phone, String password) {
//        Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();
        String url="https://dev.rishavacharya.com.np/api/register";
        RequestQueue rq= Volley.newRequestQueue(FirstActivity.this);
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Log.e("Response:", response);
                try {
                    Toast.makeText(FirstActivity.this, "Registered Succesfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(FirstActivity.this, SignupActivity.class);
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(FirstActivity.this, "Registered Unsuccesfully", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FirstActivity.this, "Error: "+error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> para= new HashMap<>();
                para.put("name", name);
                para.put("email", email);
                para.put("phone", phone);
                para.put("password", password);
                return para;
            }

        };
        rq.add(sr);
    }


}
