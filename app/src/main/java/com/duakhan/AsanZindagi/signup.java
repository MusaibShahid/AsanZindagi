package com.duakhan.AsanZindagi;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.duakhan.AsanZindagi.databinding.ActivitySignupBinding;
import com.duakhan.AsanZindagi.model.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
public class signup extends AppCompatActivity {
    ActivitySignupBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    ImageView arrow;
//animation
    Animation leftAnim;
    CardView layout_anim2;
    //animation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//animation
        leftAnim = AnimationUtils.loadAnimation(this,R.anim.left_anim);
        layout_anim2 =findViewById(R.id.pagesignup);
        layout_anim2.setAnimation(leftAnim);
//animation
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(signup.this);
        progressDialog.setTitle("creating account");
        progressDialog.setMessage("we are creating your account");
      binding.btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               progressDialog.show();
                auth.createUserWithEmailAndPassword
                        (binding.SIGNUPEmail.getText().toString(), binding.SIGNUPPass.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                String id = task.getResult().getUser().getUid();
                                progressDialog.dismiss();
                                if (task.isSuccessful()) {
                                  //try intent
                                    Intent intent=new Intent(signup.this,login.class);
                                    startActivity(intent);
                                    //try intent
                                    user User = new user(
                                            binding.SIGNUPEmail.getText().toString() ,
                                            binding.contact.getText().toString() ,
                                            binding.SIGNUPPass.getText().toString(),
                                            binding.user1.getText().toString(),
                                            id
                                    );
                                    database.getReference().child("User").child(id).setValue(User);
                                    Toast.makeText(signup.this, "user created successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                } }
                        }); }
        });        }
int counter=0;
    @Override
    public void onBackPressed() {
        counter++;
        if(counter==2)
        super.onBackPressed();
    }}