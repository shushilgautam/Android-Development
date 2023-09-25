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

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    EditText email,password;
    Button login,register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinlayout);
        email=findViewById(R.id.loginEmail);
        password=findViewById(R.id.loginPassword);
        login=findViewById(R.id.signin);
        register=findViewById(R.id.intentRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignupActivity.this,FirstActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().isEmpty()||password.getText().toString().isEmpty())
                {
                    Toast.makeText(SignupActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                postDataUsingVolley(email.getText().toString(),password.getText().toString());
            }
        });


    }

    private void postDataUsingVolley(String email, String password) {
        String url="https://dev.rishavacharya.com.np/api/login";
        RequestQueue rq = Volley.newRequestQueue(SignupActivity.this);
        StringRequest sr= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(email,response.toString());

                try {
                  Toast.makeText(SignupActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignupActivity.this, MenuActivity.class);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(SignupActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignupActivity.this, "Error: "+error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> para= new HashMap<>();
                para.put("email", email);
                para.put("password", password);
                return para;
            }

        };
        rq.add(sr);
    }
}
