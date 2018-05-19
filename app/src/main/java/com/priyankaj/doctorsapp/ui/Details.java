package com.priyankaj.doctorsapp.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.AppointmentDetails;
import com.priyankaj.doctorsapp.model.AppointmentDetailsRequest;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.DoctorDetails;
import com.priyankaj.doctorsapp.model.VisionDetails;

import java.util.ArrayList;
import java.util.Calendar;

public class Details extends AppCompatActivity implements DoctorAppContract.View{
    static EditText DateEdit;
    static EditText timeEdit;
    private Button btnBook;
    private EditText edtName;
    private EditText edtContact;
    private DoctorAppContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.book);

        PresenterInjector.injectDoctorAppPresenter(this);

        DateEdit = (EditText) findViewById(R.id.et1);
        timeEdit = (EditText) findViewById(R.id.et2);
        edtName = findViewById(R.id.edt_name);
        edtContact = findViewById(R.id.edt_contact);

        DateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonDatePickerDialog(v);
            }
        });
        timeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonTimePickerDialog(v);
            }
        });

        btnBook = findViewById(R.id.btn_book);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()){
                    AppointmentDetailsRequest appointmentDetailsRequest = new AppointmentDetailsRequest();
                    appointmentDetailsRequest.setMobile(edtContact.getText().toString());
                    appointmentDetailsRequest.setDate(DateEdit.getText().toString());
                    appointmentDetailsRequest.setTime(timeEdit.getText().toString());
                    appointmentDetailsRequest.setName(edtName.getText().toString());
                    presenter.sendFormData(appointmentDetailsRequest);
                }
            }
        });



    }


    public void showTruitonDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            DateEdit.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

    public void showTruitonTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public static class TimePickerFragment extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            DateEdit.setText(DateEdit.getText());
            timeEdit.setText( hourOfDay + ":" + minute);
        }
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

    }

    @Override
    public void showformDisplaySuccess(AppointmentDetails.Appointments appointments) {

        Toast.makeText(this,"Apointment scheduled successfully!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showformDisplayFaliure() {

    }

    private boolean validateInput(){
        return true;
    }
}

