package com.duakhan.AsanZindagi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash_Activity extends AppCompatActivity {
//animation
    ImageView imageView;
    Animation topAnim;
//animation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar();
//animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        imageView =findViewById(R.id.logo);
        imageView.setAnimation(topAnim);
//animation
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
               Intent intent = new Intent(splash_Activity.this,login
                       .class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }}