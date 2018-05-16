package com.priyankaj.doctorsapp.ui;

/**
 * Created by Priyanka on 01-08-2017.
 */


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.priyankaj.doctorsapp.R;

public class SplashScreenActivity extends AppCompatActivity
{

    private  static int splash_delay_time=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new  Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent intent=new Intent(SplashScreenActivity.this,Slider.class);
                startActivity(intent);
                finish();
            }
        },splash_delay_time);

    }

}
