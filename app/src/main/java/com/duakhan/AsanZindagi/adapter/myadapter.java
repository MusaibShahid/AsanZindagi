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
import com.duakhan.AsanZindagi.Doctor_Profile;
import com.duakhan.AsanZindagi.R;
import com.duakhan.AsanZindagi.model.modelR2;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
public class myadapter extends FirebaseRecyclerAdapter<modelR2,myadapter.myviewholder>
{
    public myadapter(@NonNull FirebaseRecyclerOptions<modelR2> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull modelR2 modelR2) {
        holder.name_text.setText(modelR2.getUserName());
        holder.special_txt.setText(modelR2.getSpecialization());
        holder.location_txt.setText(modelR2.getAddress());
        Glide.with(holder.img1.getContext()).load(modelR2.getProfilepic()).into(holder.img1);
        //img profile
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Doctor_Profile.class);
                intent.putExtra("Username",modelR2.getUserName());
                intent.putExtra("Profilepic",modelR2.getProfilepic());
                intent.putExtra("Specialization",modelR2.getSpecialization());
                intent.putExtra("Days",modelR2.getDays());
                intent.putExtra("Time", modelR2.getTime());
                intent.putExtra("Fee", modelR2.getFee());
                intent.putExtra("Contact", modelR2.getContact());
                intent.putExtra("Email", modelR2.getEmail());
                intent.putExtra("Address", modelR2.getAddress());
                intent.putExtra("Serid", modelR2.getserid());
                view.getContext().startActivity(intent);
            }});
        //imgprofile
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows,parent,false);
        return new myviewholder(view);
    }
    public  class myviewholder extends RecyclerView.ViewHolder{
        ImageView img1;
        TextView name_text,special_txt, location_txt;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img1=itemView.findViewById(R.id.img1);
            name_text=itemView.findViewById(R.id.name_text);
            special_txt=itemView.findViewById(R.id.special_text );
            location_txt=itemView.findViewById(R.id.address);
        }}}
