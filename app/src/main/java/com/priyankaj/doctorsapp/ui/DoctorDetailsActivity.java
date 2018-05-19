package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.Doctors;

public class DoctorDetailsActivity extends Activity{
Button book;

private Doctors doctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.docdet);

        if(getIntent().hasExtra("doctor")){
            doctor = getIntent().getParcelableExtra("doctor");
        }
        book=(Button)findViewById(R.id.bookbutton);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Details.class);
                startActivity(i);
            }
        });

        ((TextView)findViewById(R.id.myImageViewText)).setText(doctor.getName());
        ((TextView)findViewById(R.id.txt_category)).setText(doctor.getCategory());
        ((TextView)findViewById(R.id.txt_qualification)).setText(doctor.getQualification());
        ((TextView)findViewById(R.id.txt_timings)).setText(doctor.getDetail());
    }
}
