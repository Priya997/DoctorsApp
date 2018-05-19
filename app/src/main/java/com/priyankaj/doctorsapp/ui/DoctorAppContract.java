package com.priyankaj.doctorsapp.ui;

import android.app.Activity;

import com.priyankaj.doctorsapp.BasePresenter;
import com.priyankaj.doctorsapp.BaseView;
import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.AppointmentDetails;
import com.priyankaj.doctorsapp.model.AppointmentDetailsRequest;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.DoctorDetails;
import com.priyankaj.doctorsapp.model.VisionDetails;

import java.util.ArrayList;

/**
 * Created by Vibhuti on 5/9/2018.
 */

public class DoctorAppContract {

    /**
     * Doctor app screen View
     */
    interface View extends BaseView<Presenter> {

        public void displayCategoryDetails(ArrayList<CategoryDetails.Category> categoryDetailsList);
        public void displayVisionDetails(ArrayList<VisionDetails.Vision> visionDetailsList);
        public void displayAboutDetails(ArrayList<AboutDetails.AboutUs> aboutDetailsList);
        public void displayDoctorDetails(ArrayList<DoctorDetails.Doctors> doctorDetailsList);
        public void showformDisplaySuccess(AppointmentDetails.Appointments appointments);
        public void showformDisplayFaliure();
    }

    /**
     * Doctor app screen Presenter
     */
    interface Presenter extends BasePresenter {
        void fetchCategoryDetails(Activity context);
        void fetchVisionDetails(Activity context);
        void fetchAboutDetails(Activity context);
        void fetchDoctorDetails(Activity context);
        void sendFormData(AppointmentDetailsRequest appointmentDetailsRequest);
    }
}
