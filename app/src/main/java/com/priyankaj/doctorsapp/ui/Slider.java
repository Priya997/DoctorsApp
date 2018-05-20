package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.andexert.library.RippleView;
import com.priyankaj.doctorsapp.R;

public class Slider extends Activity implements View.OnClickListener,RippleView.OnRippleCompleteListener{
private Button book;
//private TextView txtAbout,txtVision;
//private CardView cvAbout,cvVision;
private RippleView rvAbout,rvVision,rvBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setExitTransition(new Explode());
        }

        setContentView(R.layout.slider);

//        book=findViewById(R.id.book);
//        book.setOnClickListener(this);
//
//        txtAbout=findViewById(R.id.txt_about);
//        txtAbout.setOnClickListener(this);
//
//        cvAbout=findViewById(R.id.cv_about);
//        cvAbout.setOnClickListener(this);
//
//        cvVision=findViewById(R.id.cv_vision);
//        cvVision.setOnClickListener(this);
//
//        txtVision=findViewById(R.id.txt_vision);
//        txtVision.setOnClickListener(this);

        rvAbout=findViewById(R.id.rv_about);
        rvAbout.setOnRippleCompleteListener(this);

        rvAbout=findViewById(R.id.rv_vision);
        rvAbout.setOnRippleCompleteListener(this);

        rvBook=findViewById(R.id.rv_book);
        rvBook.setOnRippleCompleteListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.book:
                Intent intent = new Intent(getApplicationContext(), CatergoryActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_about:
            case R.id.cv_about:
                 intent = new Intent(Slider.this,AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_vision:
            case R.id.cv_vision:
                 intent = new Intent(Slider.this,VisionActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onComplete(RippleView rippleView) {
        switch (rippleView.getId()){
            case R.id.rv_about:
                Intent intent = new Intent(Slider.this,AboutActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                } else {
                    startActivity(intent);
                }
                break;
            case R.id.rv_vision:
                intent = new Intent(Slider.this,VisionActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                } else {
                    startActivity(intent);
                }
                break;
            case R.id.rv_book:
                intent = new Intent(Slider.this,CatergoryActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                } else {
                    startActivity(intent);
                }
                break;
        }
    }
}