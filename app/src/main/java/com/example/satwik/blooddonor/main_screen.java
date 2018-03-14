package com.example.satwik.blooddonor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by satwik on 04-12-2017.
 */

public class main_screen extends Activity {

    protected void onCreate(Bundle savedInstanceStale) {
        super.onCreate(savedInstanceStale);

        setContentView(R.layout.after_login);
        Button donate=(Button)findViewById(R.id.circle_btn_donate);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent intent=new Intent(main_screen.this,donate.class);
startActivity(intent);


            }
        });



    }

}