package com.example.browser;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    String url;
    EditText editText;
    Button search;
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);
        editText=findViewById(R.id.editText);
        search=findViewById(R.id.btnSearch);
        webView=findViewById(R.id.webView);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               url=editText.getText().toString();
               webView.setWebViewClient(new WebViewClient());
               webView.getSettings().setJavaScriptEnabled(true);
               webView.loadUrl(url);

            }
        });

    }
}
