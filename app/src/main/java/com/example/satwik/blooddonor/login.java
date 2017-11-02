package com.example.satwik.blooddonor;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by satwik on 20-09-2017.
 */

public class login extends Activity {
private String entered_username;
    private String serverUrl="http://192.168.31.8/blood_donor/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceStale)
    {
        super.onCreate(savedInstanceStale);
        setContentView(R.layout.login_intent);
        final EditText login_username=(EditText)findViewById(R.id.ET_login_username);
        final EditText login_password=(EditText)findViewById(R.id.ET_login_password);
        Button login_button=(Button)findViewById(R.id.btn_login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entered_username = login_username.getText().toString();
                String entered_password = login_password.getText().toString();
                if (entered_username.length() <= 1 || entered_password.length() <= 1 || entered_username.equals("") || entered_password.equals("")) {
                    Toast.makeText(login.this, "please enter valid username and password", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

    }

}
