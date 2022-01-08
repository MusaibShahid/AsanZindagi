package com.duakhan.AsanZindagi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.duakhan.AsanZindagi.databinding.ActivityTutorProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class tutor_Profile extends AppCompatActivity {

    private Button bookingnow;
    //date and time
    String Uid=null;
    String Status = "Pending";
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;

    //date and time


    ProgressDialog progressDialog;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    String Username;



    String userName,profilepic,specialization,days,time,fee,contact,email,address,serid;

    ActivityTutorProfileBinding binding;
    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTutorProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        userName=getIntent().getStringExtra("Username");
        profilepic=getIntent().getStringExtra("Profilepic");
        specialization=getIntent().getStringExtra("Specialization");
        days=getIntent().getStringExtra("Days");
        time=getIntent().getStringExtra("Time");
        fee=getIntent().getStringExtra("Fee");
        contact=getIntent().getStringExtra("Contact");
        email=getIntent().getStringExtra("Email");
        address=getIntent().getStringExtra("Address");
        serid=getIntent().getStringExtra("Serid");

        bookingnow = view.findViewById(R.id.ask);

        callusername();


        database = FirebaseDatabase.getInstance();
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date = simpleDateFormat.format(calendar.getTime());


//Firebase get token
        final String[] Usertoken = new String[1];
        String msg;

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("tooooooooooooooo", "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        Usertoken[0] = task.getResult();
                        // Log and toast

                        Log.d("TAG", Usertoken[0]);


                    }



                });


//appointment coding

//imgprofile
        ImageView img1 = view.findViewById(R.id.img1);
        TextView userholder = view.findViewById(R.id.userholder);
        TextView specialholder = view.findViewById(R.id.specialholder);
        TextView dayholder = view.findViewById(R.id.dayholder);
        TextView timeholder = view.findViewById(R.id.timeholder);
        TextView feeholder = view.findViewById(R.id.feeholder);
        TextView contactholder = view.findViewById(R.id.contactholder);
        TextView emailholder = view.findViewById(R.id.emailholder);
        TextView addressholder = view.findViewById(R.id.addressholder);

        userholder.setText(userName);
        specialholder.setText(specialization);
        dayholder.setText(days);
        timeholder.setText(time);
        feeholder.setText(fee);
        contactholder.setText(contact);
        emailholder.setText(email);
        addressholder.setText(address);
        Glide.with(view.getContext()).load(profilepic).into(img1);


        bookingnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call appointment model and make bucket in fire
                callusername();
                //call appointment model and make bucket in firebase

                Appointment appoint = new Appointment(
                        Username,
                        serid,
                        userholder.getText().toString(),
                        timeholder.getText().toString(),
                        Status,
                        Date,
                        feeholder.getText().toString(),
                        Uid,
                        Usertoken[0]

                );

                if (Username != null && !Username.isEmpty()) {
                    database.getReference().child("Tutor_Appointment").child(serid).child(Date).setValue(appoint);
                 //   Toast.makeText(tutor_Profile.this, Username, Toast.LENGTH_LONG).show();


                    Toast.makeText(tutor_Profile.this, "thank you! now you request is in processing", Toast.LENGTH_LONG).show();

                }

            }
        });


    }
    //back activity from profile to home

//back activity from profile to home

    public void callusername() {
        home_Activity h = new home_Activity();
        Uid =auth.getInstance().getCurrentUser().getUid();
        String User_name = h.username;

       // Toast.makeText(tutor_Profile.this, Uid, Toast.LENGTH_SHORT).show();

        DatabaseReference db = FirebaseDatabase.getInstance().getReference("User");
        Query checkuser = db.orderByChild(Uid);
        //  Toast.makeText(this, checkuser.toString(), Toast.LENGTH_SHORT).show();
        checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Username = snapshot.child(Uid).child("username").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}