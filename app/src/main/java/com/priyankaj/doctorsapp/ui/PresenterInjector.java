package com.priyankaj.doctorsapp.ui;

/**
 * Encapsulates creation of all Presenters
 */
public class PresenterInjector {

    public static void injectDoctorAppPresenter(DoctorAppContract.View homeView){
        new DoctorAppPresenter(homeView);
    }

}
