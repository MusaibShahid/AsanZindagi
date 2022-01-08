package com.duakhan.AsanZindagi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Pasword_Activity extends AppCompatActivity {
    private EditText passwordEmail;
    private Button RESET_PASSWORD;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_);
        passwordEmail = (EditText)findViewById(R.id.email);
        RESET_PASSWORD =(Button)findViewById(R.id.btn_password);
        firebaseAuth = FirebaseAuth.getInstance();
        RESET_PASSWORD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = passwordEmail.getText().toString().trim();
                if(useremail.equals("")){
                    Toast.makeText(Pasword_Activity.this, "please enter your registered email ID", Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Pasword_Activity.this, "password reset email sent!", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Pasword_Activity.this,login.class));
                            }else{
                                Toast.makeText(Pasword_Activity.this, "Error is sending password reset email", Toast.LENGTH_SHORT).show();
                            } }
                    });
                } }
        }); }}