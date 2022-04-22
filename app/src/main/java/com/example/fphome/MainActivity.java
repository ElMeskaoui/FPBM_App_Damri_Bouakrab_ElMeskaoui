package com.example.fphome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;

    private LinearLayout p1;
    private LinearLayout p2;
    private LinearLayout p3;
    private LinearLayout p4;
    private LinearLayout p5;
    private LinearLayout p6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawerLayout  = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolBar);
//        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();
                switch(id){
                    case R.id.Formation:
                        Toast.makeText(MainActivity.this, "search clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Emploi:
                        Toast.makeText(MainActivity.this, "basket clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Notification:
                        Toast.makeText(MainActivity.this, "favorit clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.LogIn:
                        Toast.makeText(MainActivity.this, "promo_code clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Aboute:
                        Toast.makeText(MainActivity.this, "setting clicked", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

        p1 = (LinearLayout) findViewById(R.id.Formation);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage1();
            }
        });

        p2 = (LinearLayout) findViewById(R.id.Emploi);
        p2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openPage2();
            }
        });

        p4 = (LinearLayout) findViewById(R.id.Notification);
        p4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openPage4();
            }
        });

        p5 = (LinearLayout) findViewById(R.id.Aboute);
        p5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openPage5();
            }
        });
        p6 = (LinearLayout) findViewById(R.id.LogIn);
        p6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openPage6();
            }
        });



    }

            private void openPage1(){
                Intent intent = new Intent(this,ListFormation.class);
                startActivity(intent);
            }
            private void openPage2(){
                Intent intent = new Intent(this,Page2.class);
                startActivity(intent);
            }

            private void openPage4(){
                Intent intent = new Intent(this,Page4.class);
                startActivity(intent);
            }
            private void openPage5(){
                Intent intent = new Intent(this,Page3.class);
                startActivity(intent);
            }
            private void openPage6(){
                Intent intent = new Intent(this,Page6.class);
                startActivity(intent);
            }
}