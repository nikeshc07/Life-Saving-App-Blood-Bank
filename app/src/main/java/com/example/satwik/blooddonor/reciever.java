package com.example.satwik.blooddonor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by satwik on 20-07-2018.
 */

public class reciever extends AppCompatActivity {
    private RecyclerView mRecycler;
    private DatabaseReference mdatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donors_list);
        mdatabaseReference=FirebaseDatabase.getInstance().getReference().child("blooddonor-98107");
        mdatabaseReference.keepSynced(true);

        mRecycler=(RecyclerView)findViewById(R.id.myrecyclerview);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}