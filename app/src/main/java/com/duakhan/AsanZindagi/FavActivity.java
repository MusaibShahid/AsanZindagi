package com.duakhan.AsanZindagi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class FavActivity extends AppCompatActivity {
    Button logoutbtn;
    SharedPreferences sh;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        logoutbtn=findViewById(R.id.logout_btn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh=getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sh.edit();
                editor.clear();
                editor.apply();
                finish();
                Intent i = new Intent(FavActivity.this, login.class);
                // Closing all the Activities
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |

                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                // Staring Login Activity
                startActivity(i);

            }

        });

    }
}