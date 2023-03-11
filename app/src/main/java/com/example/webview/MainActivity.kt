package com.example.webview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webn=findViewById<WebView>(R.id.webb)
        webvin(webn)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webvin(webn: WebView?) {
        if (webn != null) {
            webn.webViewClient= WebViewClient()
        }

        webn?.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
            loadUrl("https://pro402.github.io/")
        }
    }

    }
