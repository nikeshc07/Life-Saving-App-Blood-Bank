package com.example.satwik.blooddonor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import static android.app.PendingIntent.getActivity;


/**
 * Created by satwik on 20-09-2017.
 */

public class signup extends Activity  {


    @Override
    protected void onCreate(Bundle savedInstanceStale) {
        super.onCreate(savedInstanceStale);

        setContentView(R.layout.signup);


        CheckBox cb=(CheckBox)findViewById(R.id.member_org);
        final EditText org_name=(EditText)findViewById(R.id.org_name_in_signup);
        final EditText org_phno=(EditText)findViewById(R.id.org_mobileno);
        org_name.setVisibility(View.GONE);
        org_phno.setVisibility(View.GONE);

       cb.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View view) {


               if(((CheckBox) view).isChecked()){
                   org_name.setVisibility(View.VISIBLE);
                   org_phno.setVisibility(View.VISIBLE);

               }else
               {
                   org_name.setVisibility(View.GONE);
                   org_phno.setVisibility(View.GONE);
               }
           }
       });

    }

    }




