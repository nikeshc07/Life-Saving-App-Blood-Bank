package com.example.satwik.blooddonor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.satwik.blooddonor.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by satwik on 04-12-2017.
 */

public class main_screen extends Activity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView logout_btn;
    private FirebaseAuth firebaseauth;
    private Button log_out;
    private Button donate;
    private ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceStale) {
        super.onCreate(savedInstanceStale);
        setContentView(R.layout.after_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        donate = (Button) findViewById(R.id.circle_btn_donate);
        log_out = (Button) findViewById(R.id.circle_logout);
        progressDialog = new ProgressDialog(this);

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
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                progressDialog.dismiss();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getBaseContext(), main_screen.class));
        finish();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}