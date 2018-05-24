package com.priyankaj.doctorsapp.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.Doctors;
import com.priyankaj.doctorsapp.model.VisionDetails;

import java.util.ArrayList;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class AboutActivity extends AppCompatActivity implements DoctorAppContract.View{

    private DoctorAppContract.Presenter presenter;
    private TextView txtAbout;
    private MaterialProgressBar pgProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        View view = LayoutInflater.from(this).inflate(R.layout.abs_layout,null);
        TextView txtName = view.findViewById(R.id.mytext);
        txtName.setText("About");
        getSupportActionBar().setCustomView(view);

        txtAbout = findViewById(R.id.txt_about);

        PresenterInjector.injectDoctorAppPresenter(this);

        pgProgress = findViewById(R.id.progress);
        pgProgress.setVisibility(View.VISIBLE);
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

        pgProgress.setVisibility(View.GONE);
    }

    @Override
    public void displayDoctorDetails(ArrayList<Doctors> doctorDetailsList) {

    }

    @Override
    public void showformDisplaySuccess(String appointments) {

    }


    @Override
    public void showformDisplayFaliure(String message) {

    }

    @Override
    public void fetchDataFailure(String message) {

    }
}
