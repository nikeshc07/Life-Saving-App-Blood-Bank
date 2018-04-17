package com.example.satwik.blooddonor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by satwik on 18-04-2018.
 */

public class forgot_password extends AppCompatActivity {
    private EditText email;
    private Button submit;
    private FirebaseAuth firebaseAuth;
    private String username;
    @Override
    public void onCreate(Bundle savedInstanceStale)
    {
        super.onCreate(savedInstanceStale);
        setContentView(R.layout.forgotpassword);
        email=(EditText)findViewById(R.id.ET_forgot_pwd_email);
        submit=(Button)findViewById(R.id.BTN_forgot_pwd_submit);
        firebaseAuth=FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=email.getText().toString();
                if(username.equals(""))
                {
                    Toast.makeText(forgot_password.this,"enter username.",Toast.LENGTH_SHORT).show();

                }else{
                firebaseAuth.sendPasswordResetEmail(username).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(forgot_password.this,"password reset email sent.",Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(forgot_password.this,login.class));
                        }else
                        {
                            Toast.makeText(forgot_password.this,"error sending email.",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }}
        });
    }


}
