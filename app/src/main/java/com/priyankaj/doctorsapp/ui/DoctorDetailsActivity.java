package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.Doctors;

public class DoctorDetailsActivity extends Activity{
RippleView book;

private Doctors doctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setExitTransition(new Explode());
        }
        setContentView(R.layout.docdet);



        if(getIntent().hasExtra("doctor")){
            doctor = getIntent().getParcelableExtra("doctor");
        }
        book=findViewById(R.id.bookbutton);
        book.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getApplicationContext(),Details.class);
                intent.putExtra("doctor_id",doctor.getDid());
                intent.putExtra("reg_date",doctor.getRegdate());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(DoctorDetailsActivity.this).toBundle());
                } else {

                    startActivity(intent);
                }
            }
        });

        ((TextView)findViewById(R.id.myImageViewText)).setText(doctor.getName());
        ((TextView)findViewById(R.id.txt_category)).setText(doctor.getCategory());
        ((TextView)findViewById(R.id.txt_qualification)).setText(doctor.getQualification());
        ((TextView)findViewById(R.id.txt_timings)).setText(doctor.getDetail());
        ((TextView)findViewById(R.id.txt_city)).setText(doctor.getCity());
        ((TextView)findViewById(R.id.txt_email)).setText(doctor.getEmail());
        ((TextView)findViewById(R.id.txt_phone)).setText(doctor.getMobile());

        findViewById(R.id.img_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+((TextView)findViewById(R.id.txt_phone)).getText()));
                startActivity(intent);
            }
        });



        findViewById(R.id.img_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+((TextView)findViewById(R.id.txt_email)).getText())); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, ((TextView)findViewById(R.id.txt_email)).getText());
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
