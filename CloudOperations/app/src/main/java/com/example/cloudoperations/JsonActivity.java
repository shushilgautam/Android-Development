package com.example.cloudoperations;

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

import java.util.ArrayList;

public class JsonActivity extends AppCompatActivity {
    ListView json_lists;
    RequestQueue rq;
    StringRequest sr;
    ArrayList<DataModel> model=new ArrayList<>();
    String baseurl="https://dev.rishavacharya.com.np/api/subjects";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsonlayout);
        json_lists=findViewById(R.id.json_list);
        rq= Volley.newRequestQueue(this);
        sr=new StringRequest(Request.Method.GET, baseurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray array = obj.getJSONArray("msg");
                    for (int i = 0; i < array.length();i++)
                    {
                        JSONObject obj1 = array.getJSONObject(i);
                        DataModel d = new DataModel();
                        d.name = obj1.getString("name");
                        d.id = obj1.getInt("id");
                        model.add(d);
                    }
                    json_lists.setAdapter(new CustomClass(JsonActivity.this, model));
                } catch (Exception e){
                    Toast.makeText(JsonActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
                }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JsonActivity.this, "Didn't Recieve Data", Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }
}
