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
import android.view.Menu;
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
    private Button request_blood;
    private ProgressDialog progressDialog;
    public    DrawerLayout drawer;
    private  ActionBarDrawerToggle toggle;


    protected void onCreate(Bundle savedInstanceStale) {
        super.onCreate(savedInstanceStale);
        setContentView(R.layout.activity_after_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        donate = (Button) findViewById(R.id.circle_btn_donate);
        log_out = (Button) findViewById(R.id.circle_logout);
        request_blood=(Button)findViewById(R.id.circle_btn_request_blood);
        progressDialog = new ProgressDialog(this);
        firebaseauth = FirebaseAuth.getInstance();
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), donate.class);
                startActivity(intent);
            }
        });
        request_blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplication(),reciever_info.class);
                startActivity(i);
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

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this); }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);}
            else{
        super.onBackPressed();
        startActivity(new Intent(getBaseContext(), main_screen.class));

    }}

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    public void onResume() {
        super.onResume();

    }
}