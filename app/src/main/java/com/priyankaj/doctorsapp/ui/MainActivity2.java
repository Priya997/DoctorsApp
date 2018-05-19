package com.priyankaj.doctorsapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.adapter.CustomAdapter2;
import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.AppointmentDetails;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.DoctorDetails;
import com.priyankaj.doctorsapp.model.VisionDetails;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements DoctorAppContract.View{


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    private DoctorAppContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.bs_layout);
        myOnClickListener = new MyOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        removedItems = new ArrayList<Integer>();
        PresenterInjector.injectDoctorAppPresenter(this);


        presenter.fetchDoctorDetails(this);


    }


    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, Docdet.class);
            context.startActivity(intent);
        }




//            removedItems.add(selectedItemId);
//            data.remove(selectedItemPosition);
//            adapter.notifyItemRemoved(selectedItemPosition);
    }



    public void itemClicked(View view, int position) {
        if(position==1) {
            Intent intent = new Intent(MainActivity2.this, Docdet.class);
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

    }

    @Override
    public void displayVisionDetails(ArrayList<VisionDetails.Vision> visionDetailsList) {

    }

    @Override
    public void displayAboutDetails(ArrayList<AboutDetails.AboutUs> aboutDetailsList) {

    }

    @Override
    public void displayDoctorDetails(ArrayList<DoctorDetails.Doctors> doctorDetailsList) {

        if(getIntent().hasExtra("category_id")){
            String id = getIntent().getStringExtra("category_id");
            try {
            if(id!=null && !TextUtils.isEmpty(id) && Integer.parseInt(id) >=1){
                ArrayList<DoctorDetails.Doctors> doctorsByCategoryList = new ArrayList<>();
                for(DoctorDetails.Doctors doctors : doctorDetailsList){
                    String categoryId = doctors.getCategory_id();

                        if (categoryId != null && !TextUtils.isEmpty(categoryId) && Integer.parseInt(categoryId) == Integer.parseInt(id)) {
                            doctorsByCategoryList.add(doctors);
                        }
                    }
                adapter = new CustomAdapter2(doctorsByCategoryList);
                recyclerView.setAdapter(adapter);
                }
            }catch (NumberFormatException e){

            }


        }

    }

    @Override
    public void showformDisplaySuccess(AppointmentDetails.Appointments appointments) {

    }

    @Override
    public void showformDisplayFaliure() {

    }
}