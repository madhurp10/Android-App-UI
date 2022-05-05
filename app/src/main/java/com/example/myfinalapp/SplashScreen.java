package com.example.myfinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.myfinalapp.User.Dashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;

    TextView splashText;
    TextView splashText2;

    // Animations
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Hide the action bar
        getSupportActionBar().hide();

        // Hooks
        splashText = findViewById(R.id.splashText);
        splashText2 = findViewById(R.id.splashText2);

        // Animations
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        // Set Animations on elements
        splashText.setAnimation(sideAnim);
        splashText2.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Dashboard.class);
                startActivity(intent);
                finish(); // Delete the splashscreen
            }
        }, SPLASH_TIMER);

    }
}