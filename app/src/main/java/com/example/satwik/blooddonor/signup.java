package com.example.satwik.blooddonor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;
import static android.widget.Toast.LENGTH_SHORT;


/**
 * Created by satwik on 20-09-2017.
 */

public class signup extends Activity  {

    private String entered_user_name,entered_password,entered_retype_password,entered_name,entered_city;

    @Override
    protected void onCreate(Bundle savedInstanceStale) {
        super.onCreate(savedInstanceStale);

        setContentView(R.layout.signup);


        CheckBox cb=(CheckBox)findViewById(R.id.CB_member_org);
        final EditText org_name=(EditText)findViewById(R.id.ET_org_name_in_signup);
        final EditText org_phno=(EditText)findViewById(R.id.ET_org_mobileno_in_signup);
        final EditText user_name=(EditText)findViewById(R.id.ET_user_name);
        EditText password=(EditText)findViewById(R.id.ET_password);
        EditText Re_type_Passwordc=(EditText)findViewById(R.id.ET_retype_password);
        EditText name=(EditText)findViewById(R.id.ET_NAME);
        EditText city=(EditText)findViewById(R.id.ET_AREA);
        Spinner state=(Spinner)findViewById(R.id.Spinner_state);
        Button register=(Button)findViewById(R.id.btn_register);
        entered_user_name=user_name.getText().toString();
        entered_password=password.getText().toString();
        entered_retype_password=Re_type_Passwordc.getText().toString();
        entered_name=name.getText().toString();
        entered_city=city.getText().toString();

        final EditText pwd=(EditText)findViewById(R.id.ET_password);
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
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(entered_user_name.length()<=0||entered_password.length()<=0||entered_retype_password.length()<=0||entered_name.length()<=0){
                    Toast.makeText(signup.this,"Please fill up the details",Toast.LENGTH_LONG).show();
                }
            }
        });



    }


}



