package com.teddy.jahemerahsumatera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class  PromoActivity extends AppCompatActivity {

    //Memanggil Variabel Widget Drawer supaya bisa dicoding
    //Inisialiasi Variabel
    DrawerLayout drawerLayout;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        //buka webnya
        webView = (WebView) findViewById(R.id.promo_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.jahemerahinstansumatera.com/promo");

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.supportZoom();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv, String url) {
                if(url.startsWith("tel:") || url.startsWith("whatsapp:") || url.startsWith("tg:") || url.startsWith("facebook:") ) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        //assign variabelnya
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer (drawerLayout);
    }

    public void ClickLogo(View view){
        //Close Drawernya
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity ke Beranda
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickJahe (View view){
        //Redirect activity ke Kisah Jahe
        MainActivity.redirectActivity(this,JaheActivity.class);
    }

    public void ClickProduk (View view){
        //Redirect activity ke Produk
        MainActivity.redirectActivity(this,ProdukActivity.class);
    }

    public void ClickPromo (View view){
        //Recreate activity
        recreate();
    }

    public void ClickTestimoni (View view){
        //Redirect activity ke Testimoni
        MainActivity.redirectActivity(this,TestimoniActivity.class);
    }

    public void ClickKhasiat (View view){
        //Redirect activity ke Khasiat
        MainActivity.redirectActivity(this,KhasiatActivity.class);
    }

    public void ClickKontak (View view){
        //Redirect activity ke Kontak Kami
        MainActivity.redirectActivity(this,KontakActivity.class);
    }

    public void ClickTentang (View view){
        //Redirect activity ke Tentang Aplikasi
        MainActivity.redirectActivity(this,TentangActivity.class);
    }

    public void ClickLogout (View view){
        //Menutup Aplikasi
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        MainActivity.closeDrawer(drawerLayout);
    }

}