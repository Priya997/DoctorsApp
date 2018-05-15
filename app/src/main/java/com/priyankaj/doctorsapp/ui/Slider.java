package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.DoctorAppDetails;
import com.priyankaj.doctorsapp.model.DoctorAppSingleton;

public class Slider extends Activity implements DoctorAppContract.View{
private Button book;
private DoctorAppContract.Presenter presenter;
private DoctorAppDetails doctorAppDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider);

        PresenterInjector.injectDoctorAppPresenter(this);
        presenter.fetchDoctorAppDetails(this);

        book=findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void setPresenter(DoctorAppContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayDoctorDetails(DoctorAppDetails doctorAppDetails) {
        DoctorAppSingleton.getInstance().setmDoctorAppDetails(doctorAppDetails);
    }
}