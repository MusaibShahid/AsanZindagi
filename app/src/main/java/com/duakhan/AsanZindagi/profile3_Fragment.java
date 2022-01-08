package com.duakhan.AsanZindagi;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class profile3_Fragment extends Fragment {
    private FirebaseAuth auth;
    DatabaseReference reference;
    FirebaseDatabase database;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    String userName,profilepic,specialization,days,time,fee,contact,email,address,serid;
    public profile3_Fragment() {
    }
    public profile3_Fragment( String userName,String profilepic, String specialization,  String days,String time, String fee,
                             String contact, String email, String address,String serid) {
        this.userName=userName;
        this.profilepic=profilepic;
        this.specialization=specialization;
        this.days=days;
        this.time=time;
        this.fee=fee;
        this.contact=contact;
        this.email=email;
        this.address=address;
    }
    public static profile3_Fragment newInstance(String param1, String param2) {
        profile3_Fragment fragment = new profile3_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        } }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile3_, container, false);
        ImageView img1=view.findViewById(R.id.img1);
        TextView userholder=view.findViewById(R.id.userholder);
        TextView specialholder=view.findViewById(R.id.specialholder);
        TextView dayholder =view.findViewById(R.id.dayholder);
        TextView timeholder =view.findViewById(R.id.timeholder);
        TextView feeholder=view.findViewById(R.id.feeholder);
        TextView contactholder =view.findViewById(R.id.contactholder);
        TextView emailholder=view.findViewById(R.id.emailholder);
        TextView addressholder=view.findViewById(R.id.addressholder);
        userholder.setText(userName);
        specialholder.setText(specialization);
        dayholder.setText(days);
        timeholder.setText(time);
        feeholder.setText(fee);
        contactholder.setText(contact);
        emailholder.setText(email);
        addressholder.setText(address);
        Glide.with(getContext()).load(profilepic).into(img1);
        return view;
    }
    public void onBackPressed(){
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new Tutor())
                .addToBackStack(null).commit();
    }}