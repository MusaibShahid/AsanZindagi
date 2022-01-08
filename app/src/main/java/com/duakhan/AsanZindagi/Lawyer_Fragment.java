package com.duakhan.AsanZindagi;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.duakhan.AsanZindagi.adapter.myadapter2;
import com.duakhan.AsanZindagi.model.modellaw;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
public class Lawyer_Fragment extends Fragment {
    RecyclerView rec_view;
    myadapter2 adapterlaw;
    public Lawyer_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lawyer, container, false);
        rec_view=(RecyclerView)view.findViewById(R.id.rec_view);
        rec_view.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<modellaw> options=
                new FirebaseRecyclerOptions.Builder<modellaw>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Lawyer"),modellaw.class)
                        .build();
        adapterlaw=new myadapter2(options);
        rec_view.setAdapter(adapterlaw);
        SearchView simpleSearchView = (SearchView) view.findViewById(R.id.simpleSearchView1); // inititate a search view
// perform set on query text listener event
        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // do something on text submit
                process_search(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
// do something when text changes
                process_search(newText);
                return false;
            }});
        return view;
    }
    @Override
    public void onStart()
    {
        super.onStart();
        adapterlaw.startListening();
    }
    @Override
    public void onStop()
    {
        super.onStop();
        adapterlaw.stopListening();
    }
    private void process_search(String s){
        FirebaseRecyclerOptions<modellaw>  option=
                new FirebaseRecyclerOptions.Builder<modellaw>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Lawyer")
                                        .orderByChild("specialization").startAt(s).endAt(s+"\uf8ff")
                                ,modellaw.class)
                        .build();
        adapterlaw=new myadapter2(option);
        adapterlaw.startListening();
        rec_view.setAdapter(adapterlaw);
    }}



