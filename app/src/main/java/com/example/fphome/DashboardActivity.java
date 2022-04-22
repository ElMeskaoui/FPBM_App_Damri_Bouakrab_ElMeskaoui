package com.example.fphome;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;

    private TextView firstname;
    private FirebaseAuth auth ;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = firebaseDatabase.getReference("student");
    String userId;

    private LinearLayout p1;
    private LinearLayout p2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        firstname = findViewById(R.id.firstName);

        auth = FirebaseAuth.getInstance();

        if (auth!= null){

            FirebaseUser user = auth.getCurrentUser();

            userId = user.getUid();


        }



        myRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String first = String.valueOf(snapshot.child("firstname").getValue());
                firstname.setText(first);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        p1 = (LinearLayout) findViewById(R.id.Diplomes);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage1();
            }
        });

        p2 = (LinearLayout) findViewById(R.id.Resutls);
        p2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openPage2();
            }
        });


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
                        Toast.makeText(DashboardActivity.this, "search clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Emploi:
                        Toast.makeText(DashboardActivity.this, "basket clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Notification:
                        Toast.makeText(DashboardActivity.this, "favorit clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.LogIn:
                        Toast.makeText(DashboardActivity.this, "promo_code clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Aboute:
                        Toast.makeText(DashboardActivity.this, "setting clicked", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });


    }
    private void openPage1(){
        Intent intent = new Intent(this, Diploma.class);
        startActivity(intent);
    }
    private void openPage2(){
        Intent intent = new Intent(this, Resutls.class);
        startActivity(intent);
    }

}