package com.example.csitmentor;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfViewerActivity extends AppCompatActivity {
    PDFView pdf;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_viewer_layout);
        pdf=findViewById(R.id.pdf);
        Intent intent=getIntent();
        String link=intent.getStringExtra("link");
        new RetrivePDFfromUrl().execute(link);
        }

    private class RetrivePDFfromUrl extends AsyncTask<String,Void,InputStream> {
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
