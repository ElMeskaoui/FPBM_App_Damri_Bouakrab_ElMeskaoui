package com.example.fphome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Page6 extends AppCompatActivity {

    TextInputLayout t1,t2;
    ProgressBar bar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        t1=(TextInputLayout)findViewById(R.id.email_login);
        t2=(TextInputLayout)findViewById(R.id.pwd_login);
        bar=(ProgressBar)findViewById(R.id.progressBar3_login);
        mAuth = FirebaseAuth.getInstance();
    }

    public void signinhere(View view)
    {
        bar.setVisibility(View.VISIBLE);
        String email=t1.getEditText().getText().toString();
        email = email+"@gmail.com";
        String password=t2.getEditText().getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(Page6.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            bar.setVisibility(View.INVISIBLE);
                            Intent intent=new Intent(Page6.this,DashboardActivity.class);
                            startActivity(intent);
                        } else
                        {
                            bar.setVisibility(View.INVISIBLE);
                            //t1.getEditText().setText("");
                            //t2.getEditText().setText("");
                            Toast.makeText(getApplicationContext(),"Invalid email/password",Toast.LENGTH_LONG).show();
                        }

                        // ...
                    }
                });



    }
}