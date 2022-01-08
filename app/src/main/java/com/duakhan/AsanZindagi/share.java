package com.duakhan.AsanZindagi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class share extends AppCompatActivity {
ImageView share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        share = findViewById(R.id.share_btn);
share.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        try {
            Intent intent=new Intent(Intent.ACTION_SENDTO);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,"Demo share");
            String shareMessage="https://www.youtube.com/watch?v=fjR2JopoHgQ";
            intent.putExtra(Intent.EXTRA_TEXT,shareMessage);
            startActivity(Intent.createChooser(intent,"share by"));


        }catch (Exception e){

            Toast.makeText(share.this, "Error Occured", Toast.LENGTH_SHORT).show();
        }

    }
});

         }
}