package com.duakhan.AsanZindagi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.duakhan.AsanZindagi.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    ActivityLoginBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth auth;
    private TextView forget_password;
    String email="";
    String password="";
    //animation
    Animation leftAnim, rightAnim;
    CardView box1;
    //animation


    SharedPreferences sh;
    SharedPreferences.Editor editor;


    //nonfuntional attributes
    ImageView google,facebook,twiter;
    //non functional attributes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //nonfuntional attributes
        google = findViewById(R.id.gogle);
        facebook = findViewById(R.id.fb);
        twiter = findViewById(R.id.twiter);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(login.this, "Not Fount Yet", Toast.LENGTH_SHORT).show();
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(login.this, "Not Fount Yet", Toast.LENGTH_SHORT).show();
            }
        });
        twiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(login.this, "Not Fount Yet", Toast.LENGTH_SHORT).show();
            }
        });

        //nonfuntional attributes
//anima
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.left_anim);
        box1 = findViewById(R.id.box1);
        box1.setAnimation(leftAnim);
//anim
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(login.this);
        progressDialog.setTitle("Login account");
        progressDialog.setMessage("we are Login your account");
        TextView SIGNUP = (TextView) findViewById(R.id.SIGNUP);
        forget_password = (TextView) findViewById(R.id.tvforgotdoctor);


        sh = getSharedPreferences("data", MODE_PRIVATE);
        editor = sh.edit();
        email = sh.getString("E", "");
        password = sh.getString("P", "");


        if (!email.isEmpty() && !password.isEmpty()) {

            Intent intent = new Intent(login.this, home_Activity.class);
            startActivity(intent);

        }


        SIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SIGNUP = new Intent(login.this, signup.class);
                startActivity(SIGNUP);
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, Pasword_Activity.class));
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                auth.signInWithEmailAndPassword(binding.loginEmail.getText().toString(), binding.loginPass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if (task.isSuccessful()) {
                                    editor.putString("E", binding.loginEmail.getText().toString());
                                    editor.putString("P", binding.loginPass.getText().toString());
                                    editor.commit();

                                    Intent intent = new Intent(login.this, home_Activity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

//        if (auth.getCurrentUser() != null) {
//            Intent intent = new Intent(login.this, home_Activity.class);
//            startActivity(intent);
//        }
//

    }

    //exit
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setIcon(R.drawable.exit);
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
        }
    //exit