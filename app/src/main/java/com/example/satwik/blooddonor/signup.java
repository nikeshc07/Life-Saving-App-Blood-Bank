package com.example.satwik.blooddonor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.app.PendingIntent.getActivity;


public class signup extends Activity {
    private FirebaseAuth auth;
    private ProgressDialog progressdialogue;
    private String entered_user_name, entered_password, entered_retype_password, entered_permanentAddress, entered_name, entered_city, entered_state, entered_mobile_number, entered_bloodgroup, entered_age, entered_email;
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;
    private EditText user_name;
    private EditText password;
    private Button register;
    private EditText Re_type_Password;
    private EditText name;
    private EditText city;
    private Spinner state, bloodgroup;
    private EditText e_mail;
    private EditText mobile_number, Age, permanentAddress;


    @Override
    protected void onCreate(Bundle savedInstanceStale) {
        super.onCreate(savedInstanceStale);

        setContentView(R.layout.signup);
        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        CheckBox cb = (CheckBox) findViewById(R.id.CB_member_org);
        final EditText org_name = (EditText) findViewById(R.id.ET_org_name_in_signup);
        final EditText org_phno = (EditText) findViewById(R.id.ET_org_mobileno_in_signup);
        user_name = (EditText) findViewById(R.id.ET_user_name);
        password = (EditText) findViewById(R.id.ET_password);
        e_mail = (EditText) findViewById(R.id.ET_emailid);
        Re_type_Password = (EditText) findViewById(R.id.ET_retype_password);
        name = (EditText) findViewById(R.id.ET_NAME);
        city = (EditText) findViewById(R.id.ET_AREA);
        state = (Spinner) findViewById(R.id.Spinner_state);
        register = (Button) findViewById(R.id.btn_register);
        bloodgroup = (Spinner) findViewById(R.id.Spinner_BloodGroup);
        mobile_number = (EditText) findViewById(R.id.ET_MOBILE);
        Age = (EditText) findViewById(R.id.ET_age);
        permanentAddress = (EditText) findViewById(R.id.ET_Address);
        progressDialog = new ProgressDialog(this);
        org_name.setVisibility(View.GONE);
        org_phno.setVisibility(View.GONE);
        entered_user_name = user_name.getText().toString().trim();
        entered_password = password.getText().toString().trim();
        entered_retype_password = Re_type_Password.getText().toString().trim();
        entered_name = name.getText().toString().trim();
        entered_city = city.getText().toString().trim();
        entered_state = state.getSelectedItem().toString().trim();
        entered_mobile_number = mobile_number.getText().toString().trim();
        entered_bloodgroup = bloodgroup.getSelectedItem().toString().trim();
        entered_age = Age.getText().toString().trim();
        entered_email = e_mail.getText().toString();
        entered_permanentAddress = permanentAddress.getText().toString().trim();
        cb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (((CheckBox) view).isChecked()) {
                    org_name.setVisibility(View.VISIBLE);
                    org_phno.setVisibility(View.VISIBLE);

                } else {
                    org_name.setVisibility(View.GONE);
                    org_phno.setVisibility(View.GONE);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_name.getText().toString().trim().equalsIgnoreCase("")) {
                    user_name.setError("enter username");
                    return;
                }else{
                    user_name.setError(null);
                }
                if (password.getText().toString().trim().length() <= 8){
                    password.setError("password must contain more than 8 characters ");
                    return;
                }

                String email="";
                        String Password="";

                try
                {
                   email= e_mail.getText().toString().trim();
                    Password = password.getText().toString().trim();
                    if(email.equals("")||email.equals(null))
                    {
                        e_mail.setError("enter email");
                        return;
                    }else
                    {
                        e_mail.setError(null);
                    }
                    if(Password.equals(null)||Password.equals(""))
                    {
                        password.setError("password must contain more than 8 characters");
                        return;
                    }else
                    {
                        password.setError(null);
                    }
                }catch(Exception e)
                {
                    Toast.makeText(signup.this,""+e,Toast.LENGTH_LONG).show();
                }
                progressDialog.setMessage("Registering user..");
                progressDialog.show();
                //create user
                auth.createUserWithEmailAndPassword(email, Password)
                        .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(signup.this, "registering user..." + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.



                                if (!task.isSuccessful()) {
                                    Toast.makeText(signup.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    saveDBInformation();
                                    startActivity(new Intent(signup.this, main_screen.class));
                                    finish();
                                }
                                progressDialog.dismiss();
                            }
                        });

            }
        });
    }

    private void saveDBInformation() {


        userInformation user_info = new userInformation(entered_user_name, entered_password, entered_retype_password, entered_name, entered_city, entered_state, entered_mobile_number, entered_bloodgroup, entered_age, entered_email, entered_permanentAddress);
        FirebaseUser user = auth.getCurrentUser();


        databaseReference.child(user.getUid()).setValue(user_info);
        Toast.makeText(this, "saving info..", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onResume() {

        super.onResume();

    }
}