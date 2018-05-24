package com.priyankaj.doctorsapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.adapter.CategoryAdapter;
import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.Doctors;
import com.priyankaj.doctorsapp.model.VisionDetails;
import com.priyankaj.doctorsapp.utils.Utils;

import java.util.ArrayList;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class CatergoryActivity extends AppCompatActivity implements DoctorAppContract.View,CategoryAdapter.CategoryClickedListener{


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Integer> removedItems;
    private DoctorAppContract.Presenter presenter;
    private ArrayList<CategoryDetails.Category> mCategoryDetailsList;
    private MaterialProgressBar pgProgress;
    private ArrayList<Doctors> mDoctorDetailsList;
    private TextView txtError,txtErrorRetry;
    private LinearLayout linlayError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        View view = LayoutInflater.from(this).inflate(R.layout.abs_layout,null);
        TextView txtName = view.findViewById(R.id.mytext);
        txtName.setText("Category");
        getSupportActionBar().setCustomView(view);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        removedItems = new ArrayList<Integer>();

        PresenterInjector.injectDoctorAppPresenter(this);

        pgProgress = findViewById(R.id.progress);


        txtError = findViewById(R.id.txt_error);
        txtErrorRetry = findViewById(R.id.txt_error_retry);
        linlayError = findViewById(R.id.linlay_error);

        txtErrorRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                call();
            }
        });

        call();


    }

    public void itemClicked(View view, int position) {
        if(position==1) {
            Intent intent = new Intent(CatergoryActivity.this, DoctorListActivity.class);
            startActivity(intent);
        }
        else {
            System.out.println("position...."+position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void setPresenter(DoctorAppContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayCategoryDetails(ArrayList<CategoryDetails.Category> categoryDetailsList) {
        mCategoryDetailsList = categoryDetailsList;
        presenter.fetchDoctorDetails(this);
    }

    @Override
    public void displayVisionDetails(ArrayList<VisionDetails.Vision> visionDetailsList) {

    }

    @Override
    public void displayAboutDetails(ArrayList<AboutDetails.AboutUs> aboutDetailsList) {

    }

    @Override
    public void displayDoctorDetails(ArrayList<Doctors> doctorDetailsList) {


                    for(Doctors doctors : doctorDetailsList){
                        try {
                        int id = Integer.parseInt(doctors.getCategory_id());
                            for (int i=0;i<mCategoryDetailsList.size();i++){
                                if(Integer.parseInt(mCategoryDetailsList.get(i).getCategory_id()) == id){
                                    int count = mCategoryDetailsList.get(i).getDoctorCount()+1;
                                    mCategoryDetailsList.get(i).setDoctorCount(count);
                                    doctors.setCategory(mCategoryDetailsList.get(i).getCategory_name());
                                    break;
                                }
                            }
                        }catch (NumberFormatException e){

                        }

                    }
                mDoctorDetailsList = doctorDetailsList;
                adapter = new CategoryAdapter(mCategoryDetailsList);
                recyclerView.setVisibility(View.VISIBLE);
                linlayError.setVisibility(View.GONE);
                recyclerView.setAdapter(adapter);
                CategoryAdapter.setCategoryClickedListener(this);

        if(pgProgress!=null && pgProgress.isShown()){
            pgProgress.setVisibility(View.GONE);
        }

    }

    @Override
    public void showformDisplaySuccess(String appointments) {

    }

    @Override
    public void onCategoryClicked(int position) {
        Intent intent = new Intent(this, DoctorListActivity.class);
        int id = Integer.parseInt(mCategoryDetailsList.get(position).getCategory_id());
        ArrayList<Doctors> doctorBasedOnCategory = new ArrayList<>();
        for(Doctors doctors : mDoctorDetailsList){
            if(doctors.getCategory_id()!=null && !TextUtils.isEmpty(doctors.getCategory_id()) && Integer.parseInt(doctors.getCategory_id())==id){
                doctorBasedOnCategory.add(doctors);
            }
        }
        intent.putParcelableArrayListExtra("doctor list",doctorBasedOnCategory);
        startActivity(intent);
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
        recyclerView.setVisibility(View.GONE);
    }

    private void call(){
        if(Utils.isNetworkConnected(this)){

            pgProgress.setVisibility(View.VISIBLE);
            presenter.fetchCategoryDetails(this);
        }else
        {
            fetchDataFailure(getResources().getString(R.string.internet_error_message));
        }
    }
}