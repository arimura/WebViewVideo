package com.example.webviewvideo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webview);

        // Enable JavaScript and set WebChromeClient
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webView.setWebChromeClient(new WebChromeClient());

        // Load HTML with video element
        String htmlContent = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "    <style>" +
                "        body { margin: 0; }" +
                "        video { width: 320px; height: 100px; }" +
                "    </style>" +
                "</head>" +
                "<body>" +
//                "    <video src=\"path/to/video.mp4\" controls></video>" +
                "    <video autoplay src=\"http://192.168.86.136:8000/Dish.mp4\" poster=\"data:image/gif;base64,R0lGODlhAQABAGAAACH5BAEKAP8ALAAAAAABAAEAAAgEAP8FBAA7\" controls></video>" +
                "</body>" +
                "</html>";

        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
