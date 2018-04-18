package com.example.satwik.blooddonor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
    public DrawerLayout drawer;


    protected void onCreate(Bundle savedInstanceStale) {
        super.onCreate(savedInstanceStale);
        setContentView(R.layout.after_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
                progressDialog.setMessage("logging out...");
                progressDialog.show();
                firebaseauth.signOut();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        progressDialog.dismiss();
                    }
                }, 3000);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        startActivity(new Intent(getBaseContext(), main_screen.class));

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        firebaseauth = FirebaseAuth.getInstance();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ID_menudonate) {

            if (firebaseauth.getCurrentUser() == null) {
                Intent nav_donate = new Intent(main_screen.this, login.class);
                startActivity(nav_donate);
                Toast.makeText(main_screen.this, "login and use the services", Toast.LENGTH_LONG).show();
                return true;
            } else {
                startActivity(new Intent(getApplicationContext(), donate.class));
            }
        }
        if (id == R.id.ET_password) {

        } else if (id == R.string.list) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onResume() {
        super.onResume();

    }
}