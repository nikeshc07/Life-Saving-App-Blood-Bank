package com.example.satwik.blooddonor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.app.PendingIntent.getActivity;
import static android.widget.Toast.LENGTH_SHORT;



public class signup extends Activity  {
    private FirebaseAuth auth;
    private ProgressDialog progressdialogue;
    private String entered_user_name,entered_password,entered_retype_password,entered_name,entered_city;

    @Override
    protected void onCreate(Bundle savedInstanceStale) {
        super.onCreate(savedInstanceStale);

        setContentView(R.layout.signup);
        auth = FirebaseAuth.getInstance();

        CheckBox cb=(CheckBox)findViewById(R.id.CB_member_org);
        final EditText org_name=(EditText)findViewById(R.id.ET_org_name_in_signup);
        final EditText org_phno=(EditText)findViewById(R.id.ET_org_mobileno_in_signup);
        final EditText user_name=(EditText)findViewById(R.id.ET_user_name);
        final EditText password=(EditText)findViewById(R.id.ET_password);
        final EditText e_mail=(EditText)findViewById(R.id.ET_emailid);
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
                String email=e_mail.getText().toString().trim();
                String Password=password.getText().toString().trim();

                //create user
                auth.createUserWithEmailAndPassword(email, Password)
                        .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(signup.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(signup.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    startActivity(new Intent(signup.this, main_screen.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}