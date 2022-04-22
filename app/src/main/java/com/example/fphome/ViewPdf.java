package com.example.fphome;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URLEncoder;

public class ViewPdf extends AppCompatActivity {
    WebView pdfview;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference reference = firebaseDatabase.getReference();
    private DatabaseReference childReference = reference.child("url");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        pdfview = (WebView) findViewById(R.id.view_pdf);
        pdfview.getSettings().setJavaScriptEnabled(true);


        String pdfname = getIntent().getStringExtra("pdfname");
        String pdfurl = getIntent().getStringExtra("pdfurl");

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle(pdfname);
        pd.setMessage("Opening....!!!");

        pdfview.setWebChromeClient(new WebChromeClient());
        pdfview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pd.dismiss();
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // Ignore SSL certificate errors
            }
        });

        String url = "https://drive.google.com/file/d/11PmFOTsxVAqN3Lw3TkaEH9teU5D_Npeu/view?usp=sharing";
        try {
            url = URLEncoder.encode(pdfurl, "UTF-8");
        } catch (Exception ex) {
        }

        /*try {
            url=URLEncoder.encode(pdfurl,"UTF-8");
            pdfview.loadUrl("https://docs.google.com/gview?embedded=true&url="+url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

        //pdfview.loadUrl(url);
        pdfview.loadUrl(url);


    }
}
