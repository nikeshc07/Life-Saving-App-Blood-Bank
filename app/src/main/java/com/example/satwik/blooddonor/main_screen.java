package com.example.satwik.blooddonor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.satwik.blooddonor.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by satwik on 04-12-2017.
 */

public class main_screen extends Activity {

    private ImageView logout_btn;
    private FirebaseAuth firebaseauth;
    private Button log_out;
    private Button donate;

    protected void onCreate(Bundle savedInstanceStale) {
        super.onCreate(savedInstanceStale);
        setContentView(R.layout.after_login);
        donate = (Button) findViewById(R.id.circle_btn_donate);
        log_out = (Button) findViewById(R.id.circle_logout);

        firebaseauth = FirebaseAuth.getInstance();
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), donate.class);
                startActivity(intent);
            }
        });
log_out.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        firebaseauth.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
});
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
   setContentView(R.layout.after_login);
    }
}