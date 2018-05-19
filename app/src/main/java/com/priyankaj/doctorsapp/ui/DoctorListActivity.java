package com.priyankaj.doctorsapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.adapter.DoctorDetailsAdapter;
import com.priyankaj.doctorsapp.model.Doctors;

import java.util.ArrayList;

public class DoctorListActivity extends AppCompatActivity{


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    ArrayList<Doctors> mDoctorsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        View view = LayoutInflater.from(this).inflate(R.layout.abs_layout,null);
        TextView txtName = view.findViewById(R.id.mytext);
        txtName.setText("Doctor");
        getSupportActionBar().setCustomView(view);
        myOnClickListener = new MyOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        removedItems = new ArrayList<Integer>();
        if(getIntent().hasExtra("doctor list")){

            mDoctorsList = getIntent().getParcelableArrayListExtra("doctor list");
            recyclerView.setAdapter(new DoctorDetailsAdapter(mDoctorsList));
        }



    }


    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, DoctorDetailsActivity.class);
            context.startActivity(intent);
        }




//            removedItems.add(selectedItemId);
//            data.remove(selectedItemPosition);
//            adapter.notifyItemRemoved(selectedItemPosition);
    }



    public void itemClicked(View view, int position) {
        if(position==1) {
            Intent intent = new Intent(DoctorListActivity.this, DoctorDetailsActivity.class);
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

}