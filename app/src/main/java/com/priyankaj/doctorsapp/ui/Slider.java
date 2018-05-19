package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.CategoryDetails;

public class Slider extends Activity{
private Button book;
private TextView txtAbout,txtVision;
private DoctorAppContract.Presenter presenter;
private CategoryDetails categoryDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider);

        book=findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CatergoryActivity.class);
                startActivity(i);
            }
        });

        txtAbout=findViewById(R.id.txt_about);
        txtAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Slider.this,AboutActivity.class);
                startActivity(intent);
            }
        });

        txtVision=findViewById(R.id.txt_vision);
        txtVision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Slider.this,VisionActivity.class);
                startActivity(intent);
            }
        });
    }

}