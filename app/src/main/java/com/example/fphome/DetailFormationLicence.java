package com.example.fphome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailFormationLicence extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_formation_licence);
        Button button1 = findViewById(R.id.viewPDF_smi);
        Button button2 = findViewById(R.id.viewPDF_svi);
        Button button3 = findViewById(R.id.viewPDF_smpc);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), pdfActivity1.class);
                intent.putExtra("pdf_url_smi","https://drive.google.com/file/d/1L_aZ3mrn0ags0oUMyPL9cSTokE7bKFbv/view?usp=sharing");
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), pdfActivity2.class);
                intent.putExtra("pdf_url_svi","https://drive.google.com/file/d/1uz1ZBZVUMWudWXbvHLRvHbQUDpgNnm5C/view?usp=sharing");
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), pdfActivity3.class);
                intent.putExtra("pdf_url_smpc","https://drive.google.com/file/d/1qhogFgSzl_Ur7V40KguF04tWpegLpgJ2/view?usp=sharing");
                startActivity(intent);
            }
        });
    }
}
