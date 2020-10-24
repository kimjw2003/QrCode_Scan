package com.example.qrcode_scan

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        if(intent.hasExtra("key")) {
            webView.settings.javaScriptEnabled = true // 자바스크립트 허용
            //웹뷰에서 새창이 뜨지 않도록 방지
            webView.webViewClient = WebViewClient()
            webView.webChromeClient = WebChromeClient()
            webView.loadUrl(intent.getStringExtra("key"))//링크 주소
        }
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){//웹뷰에서 뒤로갈 페이지가 존재한다면?
            webView.goBack()//웹사이트 내에서 뒤로가기
        }
        else{
            super.onBackPressed() //본래의 백버튼기능 수행(안드로이드)
        }
    }
}