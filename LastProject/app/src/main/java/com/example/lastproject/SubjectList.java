package com.example.lastproject;

import android.os.Bundle;
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

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class SubjectList extends AppCompatActivity {
    ArrayList<DataModel> model=new ArrayList<>();
    String url="https://dev.rishavacharya.com.np/api/subjects";
    ListView listOfSubjects;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjectlist);
        listOfSubjects=findViewById(R.id.listOfSubjects);
        RequestQueue rq= Volley.newRequestQueue(SubjectList.this);
        StringRequest sr=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj_first=new JSONObject(response);
                    JSONArray array=obj_first.getJSONArray("msg");
                    for (int i=0;i< array.length();i++){
                        JSONObject obj_index=array.getJSONObject(i);
                        DataModel d=new DataModel();
                        d.id=obj_index.getInt("id");
                        d.name=obj_index.getString("name");
                        model.add(d);
                    }
                    Toast.makeText(SubjectList.this, "Data Retrived", Toast.LENGTH_SHORT).show();
                    listOfSubjects.setAdapter(new CustomClass(SubjectList.this,model));
                } catch (Exception e){
                    Toast.makeText(SubjectList.this, "Random Error", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SubjectList.this, "Error"+error, Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }
}
