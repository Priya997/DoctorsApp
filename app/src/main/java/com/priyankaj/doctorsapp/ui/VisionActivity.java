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

public class VisionActivity extends AppCompatActivity implements DoctorAppContract.View{

    private DoctorAppContract.Presenter presenter;
    private TextView txtVision;
    private MaterialProgressBar pgProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        View view = LayoutInflater.from(this).inflate(R.layout.abs_layout,null);
        TextView txtName = view.findViewById(R.id.mytext);
        txtName.setText("Vision");
        getSupportActionBar().setCustomView(view);

        txtVision = findViewById(R.id.txt_vision);
        PresenterInjector.injectDoctorAppPresenter(this);

        pgProgress = findViewById(R.id.progress);
        pgProgress.setVisibility(View.VISIBLE);
        presenter.fetchVisionDetails(this);
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
        String strVision = visionDetailsList.get(0).getDetail();
        if(strVision!=null&&!TextUtils.isEmpty(strVision)){
            txtVision.setText(strVision);
        }

        pgProgress.setVisibility(View.GONE);
    }

    @Override
    public void displayAboutDetails(ArrayList<AboutDetails.AboutUs> aboutDetailsList) {

    }

    @Override
    public void displayDoctorDetails(ArrayList<Doctors> doctorDetailsList) {

    }

    @Override
    public void showformDisplaySuccess(String appointments) {

    }

    @Override
    public void showformDisplayFaliure() {

    }
}
