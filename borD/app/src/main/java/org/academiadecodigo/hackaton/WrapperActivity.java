package org.academiadecodigo.hackaton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WrapperActivity extends AppCompatActivity {
    static MainActivity main;

    public static void setMain(MainActivity main) {
        WrapperActivity.main = main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrapper);

        final WebView webView = findViewById(R.id.pageView);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.canGoBack();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(MainActivity.websiteToOpen);

        webView.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        FloatingActionButton skipWebsite = findViewById(R.id.fabSkip);
        skipWebsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //SKIP WEBSITE
                main.randomChoose();
                Toast.makeText(WrapperActivity.this, MainActivity.websiteToOpen, Toast.LENGTH_SHORT).show();
                webView.loadUrl(MainActivity.websiteToOpen);
            }
        });
    }

}
