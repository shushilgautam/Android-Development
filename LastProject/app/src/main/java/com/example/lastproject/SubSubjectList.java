package com.example.lastproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SubSubjectList extends AppCompatActivity {
    ArrayList<DataModelSecond> model=new ArrayList<>();
    ListView subSubject;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_subjectlist);
        subSubject=findViewById(R.id.listOfSubSubjects);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String url="https://dev.rishavacharya.com.np/api/subjects/sub-set?subject_id=";
        RequestQueue rq= Volley.newRequestQueue(SubSubjectList.this);
        StringRequest sr=new StringRequest(Request.Method.GET,url , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj_first=new JSONObject(response);
                    JSONArray array=obj_first.getJSONArray("msg");
                    for (int i=0;i< array.length();i++){
                        JSONObject obj_index=array.getJSONObject(i);
                        DataModelSecond d=new DataModelSecond();
                        d.id=obj_index.getInt("id");
                        d.name=obj_index.getString("name");
                        d.subId=obj_index.getString("subject_id");
                        model.add(d);
                    }
                    subSubject.setAdapter(new CustomClassSecond(SubSubjectList.this,model));
                } catch (Exception e){
                    Toast.makeText(SubSubjectList.this, "Random Error", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SubSubjectList.this, "Error"+error, Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }
}
