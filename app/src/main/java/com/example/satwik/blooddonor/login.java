package com.example.satwik.blooddonor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;


public class login extends Activity implements View.OnClickListener{
private String entered_username;
private ProgressDialog progressDialog;
private FirebaseAuth auth;
private Button login_button;
private EditText login_username;
private EditText login_password;
    @Override
    protected void onCreate(Bundle savedInstanceStale)
    {
        super.onCreate(savedInstanceStale);
        setContentView(R.layout.login_intent);
        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        login_username=(EditText)findViewById(R.id.ET_login_username);
        login_password=(EditText)findViewById(R.id.ET_login_password);
        login_button=(Button)findViewById(R.id.btn_login);
        login_button.setOnClickListener(this);
        if(auth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),main_screen.class));
        }
    }
    private void UserLogin()
    {
        String _login_email=login_username.getText().toString().trim();
        String _login_pwd=login_password.getText().toString().trim();

        if(TextUtils.isEmpty(_login_email)){
            //email empty
            Toast.makeText(this,"enter email",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(_login_pwd)){
            Toast.makeText(this,"enter password",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Logging in...");
        progressDialog.show();
        auth.signInWithEmailAndPassword(_login_email,_login_pwd).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    finish();
                    startActivity(new Intent(getApplicationContext(),main_screen.class));

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"enter valid credentials",Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                return;
                }
                progressDialog.dismiss();
            }
        });

    }

    @Override
    public void onClick(View view) {

        if(view == login_button){
            UserLogin();
        }

    }
}
