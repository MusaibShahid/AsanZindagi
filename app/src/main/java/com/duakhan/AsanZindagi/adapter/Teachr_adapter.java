package com.duakhan.AsanZindagi.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.duakhan.AsanZindagi.R;
import com.duakhan.AsanZindagi.model.tutor_model;
import com.duakhan.AsanZindagi.tutor_Profile;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Teachr_adapter extends FirebaseRecyclerAdapter<tutor_model,Teachr_adapter.myviewholder>
{

    public Teachr_adapter(@NonNull FirebaseRecyclerOptions<tutor_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position,@NonNull tutor_model tutor_model) {

        holder.name_text.setText(tutor_model.getUserName());
        holder.special_text.setText(tutor_model.getSpecialization());
        holder.address.setText(tutor_model.getAddress());
        Glide.with(holder.img1.getContext()).load(tutor_model.getProfilepic()).into(holder.img1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), tutor_Profile.class);
                intent.putExtra("Username",tutor_model.getUserName());
                intent.putExtra("Profilepic",tutor_model.getProfilepic());
                intent.putExtra("Specialization",tutor_model.getSpecialization());
                intent.putExtra("Days",tutor_model.getDays());
                intent.putExtra("Time", tutor_model.getTime());
                intent.putExtra("Fee", tutor_model.getFee());
                intent.putExtra("Contact", tutor_model.getContact());
                intent.putExtra("Email", tutor_model.getEmail());
                intent.putExtra("Address", tutor_model.getAddress());
                intent.putExtra("Serid", tutor_model.getserid());

                view.getContext().startActivity(intent);
            }

        });



    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.row3,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{

       ImageView img1;
       TextView name_text,special_text, address;

       public myviewholder(@NonNull View itemView) {
           super(itemView);
           img1=itemView.findViewById(R.id.img1);
           name_text =itemView.findViewById(R.id.name_text);
           special_text=itemView.findViewById(R.id.special_text);
           address=itemView.findViewById(R.id.address);

       }
   }
}
