package com.ericmenis.aplic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    public ImageView image;
    public Animation topAnim;
    public TextView CV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animatio
        topAnim = AnimationUtils.loadAnimation(this,R.anim.animation);

        //Hooks
        CV = (TextView) findViewById(R.id.titleCV);
        image = (ImageView) findViewById(R.id.imageBackground);

        Picasso.with(this).load(R.drawable.bandaroja).into(image);

        CV.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}
