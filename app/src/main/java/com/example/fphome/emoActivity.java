package com.example.fphome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class emoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp);

        Button button = findViewById(R.id.viewpdf);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WebActivity.class);
                intent.putExtra("pdf_url","https://www.toupty.com/exercice-math/5eme/arithmetique/priorite-operatoire-1.pdf");
                startActivity(intent);

            }
        });
    }
}
