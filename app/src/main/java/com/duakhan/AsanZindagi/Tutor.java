package com.duakhan.AsanZindagi;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.duakhan.AsanZindagi.adapter.Teachr_adapter;
import com.duakhan.AsanZindagi.model.tutor_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
public class Tutor extends Fragment {
    RecyclerView rec_view3;
    Teachr_adapter adapterT;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public Tutor() {
        // Required empty public constructor
    }
    public static Tutor newInstance(String param1, String param2) {
        Tutor fragment = new Tutor();
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
        View view= inflater.inflate(R.layout.fragment_tutor, container, false);
        rec_view3=(RecyclerView)view.findViewById(R.id.rec_view3);
        rec_view3.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<tutor_model> options=
                new FirebaseRecyclerOptions.Builder<tutor_model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Tutor"),tutor_model.class)
                        .build();
        adapterT=new Teachr_adapter(options);
        rec_view3.setAdapter(adapterT);
//search view
       SearchView simpleSearchView = (SearchView) view.findViewById(R.id.simpleSearchView2); // inititate a search view
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
            }
        });
        //search view
        return view;
    }
    @Override
    public void onStart()
    {
        super.onStart();
        adapterT.startListening();
    }
    @Override
    public void onStop()
    {
        super.onStop();
        adapterT.stopListening();
    }
    private void process_search(String s) {
        FirebaseRecyclerOptions<tutor_model> option =
                new FirebaseRecyclerOptions.Builder<tutor_model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Tutor")
                                        .orderByChild("specialization").startAt(s).endAt(s + "\uf8ff")
                                , tutor_model.class)
                        .build();
        adapterT = new Teachr_adapter(option);
        adapterT.startListening();
        rec_view3.setAdapter(adapterT);
    }}