package com.example.satwik.blooddonor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by satwik on 26-03-2018.
 */

public class startup_image extends Activity{
    private static boolean splashLoaded = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!splashLoaded) {
            setContentView(R.layout.startup_image);
            int secondsDelayed = 1;


            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(startup_image.this, MainActivity.class));
                    finish();
                }
            }, secondsDelayed * 500);

            splashLoaded = true;
        }
        else {
            Intent goToMainActivity = new Intent(startup_image.this, MainActivity.class);
            goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToMainActivity);
            finish();
        }    }
}
