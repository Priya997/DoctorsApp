package com.priyankaj.doctorsapp.model;

/**
 * Created by Vibhuti on 5/15/2018.
 */

public class DoctorAppSingleton {

    public DoctorAppDetails getmDoctorAppDetails() {
        return mDoctorAppDetails;
    }

    public void setmDoctorAppDetails(DoctorAppDetails mDoctorAppDetails) {
        this.mDoctorAppDetails = mDoctorAppDetails;
    }

    public static DoctorAppSingleton getmDoctorAppSingleton() {
        return mDoctorAppSingleton;
    }

    public static void setmDoctorAppSingleton(DoctorAppSingleton mDoctorAppSingleton) {
        DoctorAppSingleton.mDoctorAppSingleton = mDoctorAppSingleton;
    }

    private DoctorAppDetails mDoctorAppDetails;
    private static DoctorAppSingleton mDoctorAppSingleton;

    public static DoctorAppSingleton getInstance(){
        if(mDoctorAppSingleton == null){
            mDoctorAppSingleton = new DoctorAppSingleton();
        }
        return mDoctorAppSingleton;
    }

    public void clearInstance(){
        mDoctorAppSingleton = null;
    }

    private DoctorAppSingleton(){

    }

}
