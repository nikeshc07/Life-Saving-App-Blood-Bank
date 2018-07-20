package com.example.satwik.blooddonor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
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
        FirebaseRecyclerAdapter<reciever_info,recieverViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<reciever_info, recieverViewHolder>
                (reciever_info.class,R.layout.donors_card_view,recieverViewHolder.class,mdatabaseReference) {
            @Override
            protected void populateViewHolder(recieverViewHolder viewHolder, reciever_info model, int position) {
            viewHolder.setName(model.get_name());
            viewHolder.setAge(model.get_Age());
            viewHolder.setBloodgroup(model.get_bloodgroup());
            viewHolder.setMobile(model.get_mobile());
            }
        };
        mRecycler.setAdapter(firebaseRecyclerAdapter);
            }
public static  class recieverViewHolder extends RecyclerView.ViewHolder
{
    View mView;
    public recieverViewHolder(View itemView) {
        super(itemView);
        mView=itemView;
    }
    public void setName(String _name){
        TextView post_name=(TextView)mView.findViewById(R.id.CV_name);
        post_name.setText(_name);
    }
    public void setAge(String _Age){
        TextView post_age=(TextView)mView.findViewById(R.id.CV_age);
        post_age.setText(_Age);
    }
    public void setBloodgroup(String _bloodgroup){
        TextView post_bloodgroup=(TextView)mView.findViewById(R.id.CV_bloodgrp);
        post_bloodgroup.setText(_bloodgroup);
    }
    public void setMobile(String _mobile){
        TextView post_mobile=(TextView)mView.findViewById(R.id.CV_mobile);
        post_mobile.setText(_mobile);
    }
}
}
