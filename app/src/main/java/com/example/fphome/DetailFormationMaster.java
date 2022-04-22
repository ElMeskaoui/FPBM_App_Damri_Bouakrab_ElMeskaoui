package com.example.fphome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailFormationMaster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_formation_master);

        Button button_isi = findViewById(R.id.viewPDF_isi);
        Button button_stri = findViewById(R.id.viewPDF_stri);

        button_isi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), pdfActivity4.class);
                intent.putExtra("pdf_url_isi","https://drive.google.com/file/d/1z10iEaDrpO6TUzQmvskFgqC32A78wXpw/view?usp=sharing");
                startActivity(intent);
            }
        });

        button_stri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), pdfActivity5.class);
                intent.putExtra("pdf_url_stri","https://drive.google.com/file/d/1eKCS9CmXRCKJG9dTRZM7SPrOG1wgOk9D/view?usp=sharing");
                startActivity(intent);
            }
        });

    }
}