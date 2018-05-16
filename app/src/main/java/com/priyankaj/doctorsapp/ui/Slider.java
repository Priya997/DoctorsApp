package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.CategorySingleton;

import java.util.ArrayList;

public class Slider extends Activity implements DoctorAppContract.View{
private Button book;
private DoctorAppContract.Presenter presenter;
private CategoryDetails categoryDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider);

        PresenterInjector.injectDoctorAppPresenter(this);
        presenter.fetchCategoryDetails(this);

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
    public void displayCategoryDetails(ArrayList<CategoryDetails.Category> categoryDetailsList) {
        CategorySingleton.getInstance().setmCategoryDetailsList(categoryDetailsList);
    }
}