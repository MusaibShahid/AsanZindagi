package com.duakhan.AsanZindagi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class logout extends AppCompatActivity {
    Button logoutbtn;
//    SharedPreferences sh;
//    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        logoutbtn=findViewById(R.id.logout_btn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sh=getSharedPreferences("data",MODE_PRIVATE);
//                editor=sh.edit();
//                editor.clear();
//                editor.apply();

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(logout.this, login.class));

            }
        });

    }
}