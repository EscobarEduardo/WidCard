package com.example.gridcardviewapp2

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import java.net.URL

class WebViewApp : AppCompatActivity() {

    private val URL_BASE = "https://youtube.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_app)

        val svPantalla: WebView = findViewById(R.id.ww_Pantalla)
        svPantalla.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }
        }
        val configuracion: WebSettings = svPantalla.settings
        configuracion.javaScriptEnabled = true
        svPantalla.loadUrl(URL_BASE)




    }
    override fun onBackPressed() {
        val svPantalla2:WebView = findViewById(R.id.ww_Pantalla)
        if(svPantalla2.canGoBack()) {
            svPantalla2.goBack()
        }
        super.onBackPressed()
    }
}





