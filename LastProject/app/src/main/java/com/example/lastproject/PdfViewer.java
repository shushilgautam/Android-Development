package com.example.lastproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class PdfViewer extends AppCompatActivity {
    PDFView pdf;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_viewer);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String subId=intent.getStringExtra("Sub_id");
        pdf=findViewById(R.id.pdf);
        String pdfurl="https://dev.rishavacharya.com.np/api/subjects/set/sbquestions?subject_id="+id+"&set_id="+subId;
//        String pdfurl="gs://csit-mentor.appspot.com/notes/CSC167/Microprocessor_CSIT_Complete.pdf";
        RequestQueue rq= Volley.newRequestQueue(PdfViewer.this);
        StringRequest sr= new StringRequest(Request.Method.GET,pdfurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj= new JSONObject(response);
                    String link= obj.getString("msg");
                    new RetrivePDFfromUrl().execute(link);
                    // since loading a complete file via network is a long running
                    // task, so we don't directly execute it in the main process,
                    // instead, we create a separate process using Asynctask

                }catch (Exception e){
                    Toast.makeText(PdfViewer.this, "Catch Error", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PdfViewer.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }

    private class RetrivePDFfromUrl extends AsyncTask<String,Void, InputStream> {

        // At first doInBackground works for Asyntask. Until we download the complete
        // file, the execution continues in doInBackground

        // String... -> String array
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream=null;
            try {
                //Array 1st object access
                URL url=new URL(strings[0]);
                //opening a connection to url
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
                //if response code frm server is 200
                if (urlConnection.getResponseCode()==200) {
                    //get data via input stream
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }catch (IOException e){
                // implement a toast, specially for no connection, or timeout
                return null;
            }

            return inputStream;
            // returned inputstream goes to onPostExecute
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            //since complete pdf file is in inputstream, we load the file
            // using pdfviewer+
            pdf.fromStream(inputStream).load();
        }
    }
}
