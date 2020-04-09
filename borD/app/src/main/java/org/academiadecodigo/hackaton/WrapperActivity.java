package org.academiadecodigo.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class WrapperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrapper);

        WebView webView = findViewById(R.id.pageView);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.canGoBack();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(MainActivity.websiteToOpen);
    }
}
