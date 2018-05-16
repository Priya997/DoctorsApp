package com.priyankaj.doctorsapp.model;

import java.util.ArrayList;

/**
 * Created by Vibhuti on 5/15/2018.
 */

public class CategorySingleton {

    public ArrayList<CategoryDetails.Category> getmCategoryDetailsList() {
        return mCategoryDetailsList;
    }

    public void setmCategoryDetailsList(ArrayList<CategoryDetails.Category> mCategoryDetailsList) {
        this.mCategoryDetailsList = mCategoryDetailsList;
    }

    private ArrayList<CategoryDetails.Category> mCategoryDetailsList;
    private static CategorySingleton mDoctorAppSingleton;

    public static CategorySingleton getInstance(){
        if(mDoctorAppSingleton == null){
            mDoctorAppSingleton = new CategorySingleton();
        }
        return mDoctorAppSingleton;
    }

    public void clearInstance(){
        mDoctorAppSingleton = null;
    }

    private CategorySingleton(){

    }

}
