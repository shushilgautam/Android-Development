package com.example.jsonprojects;

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

public class FirstActivity extends AppCompatActivity {
    RequestQueue rq;
    String baseurl="https://dev.rishavacharya.com.np/api/subjects/obj-set?subject_id=1";
    StringRequest sr;
    ListView list_item;
    ArrayList<DataModel> list=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);
        list_item=findViewById(R.id.lists);
        rq= Volley.newRequestQueue(this);
        sr=new StringRequest(Request.Method.GET, baseurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Log.e("Response:", response);
                try {
                    JSONObject object_first=new JSONObject(response);
                    JSONArray array= object_first.getJSONArray("msg");
                    for (int i=0;i<array.length();i++)
                    {
                        JSONObject object_index=array.getJSONObject(i);
                        DataModel d=new DataModel();
                        d.id=object_index.getInt("id");
                        d.subject_id=object_index.getString("subject_id");
                        d.name =object_index.getString("name");
                        list.add(d);
                    }
                    list_item.setAdapter(new CustomClass(FirstActivity.this,list));
                } catch (Exception e){
                    Toast.makeText(FirstActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FirstActivity.this, "Error on getting response", Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }
}
