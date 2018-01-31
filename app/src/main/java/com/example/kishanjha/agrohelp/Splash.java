package com.example.kishanjha.agrohelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv =(TextView) findViewById(R.id.welcome);
        iv = (ImageView) findViewById(R.id.logo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.my_transition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        final Intent login = new Intent(this,MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(2500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(login);
                    finish();
                }
            }
        };timer.start();

    }
}
