package com.priyankaj.doctorsapp.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.City;
import com.priyankaj.doctorsapp.model.Doctors;
import com.priyankaj.doctorsapp.model.VisionDetails;
import com.priyankaj.doctorsapp.utils.Utils;

import java.util.ArrayList;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class VisionActivity extends AppCompatActivity implements DoctorAppContract.View{

    private DoctorAppContract.Presenter presenter;
    private TextView txtVision,txtError,txtErrorRetry;
    private LinearLayout linlayError;
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
        txtError = findViewById(R.id.txt_error);
        txtErrorRetry = findViewById(R.id.txt_error_retry);
        linlayError = findViewById(R.id.linlay_error);
        PresenterInjector.injectDoctorAppPresenter(this);

        pgProgress = findViewById(R.id.progress);


        txtErrorRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                call();
            }
        });
        call();

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
            linlayError.setVisibility(View.GONE);
            txtVision.setVisibility(View.VISIBLE);
            txtVision.setText(strVision);
        }

        if(pgProgress!=null && pgProgress.isShown()){
            pgProgress.setVisibility(View.GONE);
        }
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
    public void showformDisplayFaliure(String message) {

    }

    @Override
    public void fetchDataFailure(String message) {

        if(pgProgress!=null && pgProgress.isShown()){
            pgProgress.setVisibility(View.GONE);
        }
        linlayError.setVisibility(View.VISIBLE);
        txtError.setText(message);
        txtVision.setVisibility(View.GONE);
    }

    private void call(){
        if(Utils.isNetworkConnected(this)){
            pgProgress.setVisibility(View.VISIBLE);
            presenter.fetchVisionDetails(this);
        }else
        {
            fetchDataFailure(getResources().getString(R.string.internet_error_message));
        }
    }


    @Override
    public void displayCityDetails(ArrayList<City> cityArrayList) {

    }
}
