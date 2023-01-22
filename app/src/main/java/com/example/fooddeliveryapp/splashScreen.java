package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class splashScreen extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 2500;
    //Variables
    Animation topAnim, botAnim;
    ImageView logo;
    TextView header, slogan;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);
        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        botAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        //Hook
        logo = findViewById(R.id.logo);
        header = findViewById(R.id.header);
        slogan = findViewById(R.id.footer);

        logo.setAnimation(topAnim);
        header.setAnimation(topAnim);
        slogan.setAnimation(botAnim);

        new Handler().postDelayed(() -> {
            Intent i = new Intent(splashScreen.this, logReg.class);
            startActivity(i);
            finish();
        }, SPLASH_SCREEN);

    }

}
