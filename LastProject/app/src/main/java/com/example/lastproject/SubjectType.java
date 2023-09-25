package com.example.lastproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SubjectType extends AppCompatActivity {
    Button subjective;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_types);
        subjective=findViewById(R.id.subjective);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        subjective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SubjectType.this,SubSubjectList.class);
                i.putExtra("id",id);
                startActivity(i);
            }
        });
//        Log.d("id",id);

    }
}
