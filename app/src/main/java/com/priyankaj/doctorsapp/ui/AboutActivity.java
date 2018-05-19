package com.priyankaj.doctorsapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.AppointmentDetails;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.DoctorDetails;
import com.priyankaj.doctorsapp.model.VisionDetails;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity implements DoctorAppContract.View{

    private DoctorAppContract.Presenter presenter;
    private TextView txtAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        txtAbout = findViewById(R.id.txt_about);

        PresenterInjector.injectDoctorAppPresenter(this);


        presenter.fetchAboutDetails(this);
    }

    @Override
    public void setPresenter(DoctorAppContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public void displayCategoryDetails(ArrayList<CategoryDetails.Category> categoryDetailsList) {

    }

    @Override
    public void displayVisionDetails(ArrayList<VisionDetails.Vision> visionDetailsList) {

    }

    @Override
    public void displayAboutDetails(ArrayList<AboutDetails.AboutUs> aboutDetailsList) {
        String strAbout = aboutDetailsList.get(0).getAbout();
        if(strAbout!=null && !TextUtils.isEmpty(strAbout)){
            txtAbout.setText(strAbout);
        }
    }

    @Override
    public void displayDoctorDetails(ArrayList<DoctorDetails.Doctors> doctorDetailsList) {

    }

    @Override
    public void showformDisplaySuccess(AppointmentDetails.Appointments appointments) {

    }

    @Override
    public void showformDisplayFaliure() {

    }
}
