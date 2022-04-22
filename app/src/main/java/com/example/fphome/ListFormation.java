package com.example.fphome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListFormation extends AppCompatActivity {
    private Button licence, master;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_formation);

        licence = (Button) findViewById(R.id.licence);
        master = (Button) findViewById(R.id.master);
        licence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailLicence();
            }
        });
        master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailMaster();
            }
        });

    }
    public void openDetailLicence() {
        Intent intent = new Intent(this, DetailFormationLicence.class);
        startActivity(intent);
    }
    public void openDetailMaster() {
        Intent intent = new Intent(this, DetailFormationMaster.class);
        startActivity(intent);
    }
}