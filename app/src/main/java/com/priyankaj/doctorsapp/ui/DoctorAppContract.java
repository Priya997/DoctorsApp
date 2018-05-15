package com.priyankaj.doctorsapp.ui;

import android.app.Activity;

import com.priyankaj.doctorsapp.BasePresenter;
import com.priyankaj.doctorsapp.BaseView;
import com.priyankaj.doctorsapp.model.DoctorAppDetails;

/**
 * Created by Vibhuti on 5/9/2018.
 */

public class DoctorAppContract {

    /**
     * Doctor app screen View
     */
    interface View extends BaseView<Presenter> {

        public void displayDoctorDetails(DoctorAppDetails doctorAppDetails);
    }

    /**
     * Doctor app screen Presenter
     */
    interface Presenter extends BasePresenter {
        void fetchDoctorAppDetails(Activity context);
    }
}
