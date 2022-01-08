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
import com.duakhan.AsanZindagi.Profile;
import com.duakhan.AsanZindagi.R;
import com.duakhan.AsanZindagi.model.modellaw;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter2 extends FirebaseRecyclerAdapter<modellaw,myadapter2.myviewholder>  {


    public myadapter2(@NonNull FirebaseRecyclerOptions<modellaw> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull modellaw modellaw) {
        holder.name_text.setText(modellaw.getUserName());
        holder.special_txt.setText(modellaw.getSpecialization());
        holder.location_txt.setText(modellaw.getAddress());
        Glide.with(holder.img1.getContext()).load(modellaw.getProfilepic()).into(holder.img1);

       //imgprofile

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(), Profile.class);
                intent.putExtra("Username",modellaw.getUserName());
                intent.putExtra("Profilepic",modellaw.getProfilepic());
                intent.putExtra("Specialization",modellaw.getSpecialization());
                intent.putExtra("Days",modellaw.getDays());
                intent.putExtra("Time", modellaw.getTime());
                intent.putExtra("Fee", modellaw.getFee());
                intent.putExtra("Contact", modellaw.getContact());
                intent.putExtra("Email", modellaw.getEmail());
                intent.putExtra("Address", modellaw.getAddress());
                intent.putExtra("Serid", modellaw.getSerid());


                view.getContext().startActivity(intent);

           }
        });
//imgprofile

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row2,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        ImageView img1;
        TextView name_text,special_txt, location_txt;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img1=itemView.findViewById(R.id.img1);
            name_text=itemView.findViewById(R.id.name_text);
            special_txt=itemView.findViewById(R.id.special_text );
            location_txt=itemView.findViewById(R.id.address);

        }
    }
}