package com.example.informe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        //poner icono action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        wv1 = (WebView)findViewById(R.id.wv1);

        String URL = getIntent().getStringExtra("sitioWeb");
        wv1.setWebChromeClient(new WebChromeClient());
        wv1.loadUrl("http://" + URL);
    }

    public void Cerrar(View view){
        finish();
    }
}

