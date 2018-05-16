package com.priyankaj.doctorsapp.ui;

import android.app.Activity;

import com.priyankaj.doctorsapp.BasePresenter;
import com.priyankaj.doctorsapp.BaseView;
import com.priyankaj.doctorsapp.model.CategoryDetails;

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
    }

    /**
     * Doctor app screen Presenter
     */
    interface Presenter extends BasePresenter {
        void fetchCategoryDetails(Activity context);
    }
}
