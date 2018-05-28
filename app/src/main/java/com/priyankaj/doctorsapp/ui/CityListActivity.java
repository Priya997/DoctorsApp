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
import android.widget.TextView;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.adapter.CityAdapter;
import com.priyankaj.doctorsapp.model.City;
import com.priyankaj.doctorsapp.model.Doctors;

import java.util.ArrayList;

public class CityListActivity extends AppCompatActivity implements  CityAdapter.CityClickedListener{


    private CityAdapter cityAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private ArrayList<City> mCityList;
    private ArrayList<Doctors> mDoctorsList;

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

        if(getIntent().hasExtra("doctor list")){

            mDoctorsList = getIntent().getParcelableArrayListExtra("doctor list");
        }
        if(getIntent().hasExtra("city list")){

            mCityList = getIntent().getParcelableArrayListExtra("city list");
             cityAdapter = new CityAdapter(mCityList);
            CityAdapter.setmCityClickedListener(this);
            recyclerView.setAdapter(cityAdapter);
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCityClicked(int position) {
        Intent intent = new Intent(CityListActivity.this, DoctorListActivity.class);
        ArrayList<Doctors> doctorBasedOnCategory = new ArrayList<>();
        int id = (int) cityAdapter.getItemId(position);
        for(Doctors doctors : mDoctorsList){
            if(doctors.getCity_id()!=null && !TextUtils.isEmpty(doctors.getCity_id()) && Integer.parseInt(doctors.getCity_id())==id){
                doctorBasedOnCategory.add(doctors);
            }
        }
        intent.putParcelableArrayListExtra("doctor list",doctorBasedOnCategory);
        startActivity(intent);
    }
}