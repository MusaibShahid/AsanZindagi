package com.duakhan.AsanZindagi;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.duakhan.AsanZindagi.adapter.myadapter;
import com.duakhan.AsanZindagi.model.modelR2;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
public class    Doctor_Fragment extends Fragment {
    RecyclerView rec_view;
    myadapter adapter;
    public Doctor_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_doctor_, container, false);
        rec_view=(RecyclerView)view.findViewById(R.id.rec_view);
        rec_view.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<modelR2>option=
                new FirebaseRecyclerOptions.Builder<modelR2>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Doctor"),modelR2.class)
                .build();
      adapter=new myadapter(option);
      rec_view.setAdapter(adapter);
      SearchView simpleSearchView = (SearchView) view.findViewById(R.id.simpleSearchView); // inititate a search view
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
        adapter.startListening();
    }
    @Override
    public void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
    private void process_search(String s){
        FirebaseRecyclerOptions<modelR2>  options=
                new FirebaseRecyclerOptions.Builder<modelR2>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Doctor")
                                        .orderByChild("specialization").startAt(s).endAt(s+"\uf8ff")
                                ,modelR2.class)
                        .build();
        adapter=new myadapter(options);
        adapter.startListening();
          rec_view.setAdapter(adapter);
    }}



