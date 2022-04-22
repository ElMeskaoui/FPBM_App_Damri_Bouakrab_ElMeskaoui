package com.example.fphome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Button button = findViewById(R.id.viewpdf);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WebActivity.class);
                intent.putExtra("pdf_url","https://drive.google.com/file/d/1Pg9jGbkHGvsLW2zRu_gXEqqENhviLE_k/view?usp=sharing");
                startActivity(intent);

            }
        });
    }
}