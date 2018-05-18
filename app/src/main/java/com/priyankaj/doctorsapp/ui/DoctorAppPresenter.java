package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.priyankaj.doctorsapp.apis.DoctorDataService;
import com.priyankaj.doctorsapp.apis.ServiceFactory;
import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.DoctorDetails;
import com.priyankaj.doctorsapp.model.VisionDetails;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Vibhuti on 5/9/2018.
 */

public class DoctorAppPresenter implements DoctorAppContract.Presenter {

    private DoctorAppContract.View mView;

    public DoctorAppPresenter(DoctorAppContract.View view) {
        this.mView = view;

        // This should be the last statement
        this.mView.setPresenter(this);
    }

    @Override
    public void start(@Nullable Bundle extras) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void fetchCategoryDetails(Activity context) {

        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);
        service.getCategoryDetails()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<CategoryDetails>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(CategoryDetails categoryDetailsList) {
                            mView.displayCategoryDetails(categoryDetailsList.getCategory());
                        }
                    });

    }

    @Override
    public void fetchVisionDetails(Activity context) {
        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);
        service.getVisionDetails()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VisionDetails>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(VisionDetails visionDetails) {
                        mView.displayVisionDetails(visionDetails.getVision());
                    }
                });
    }

    @Override
    public void fetchAboutDetails(Activity context) {
        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);
        service.getAboutDetails()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AboutDetails>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(AboutDetails aboutDetails) {
                        mView.displayAboutDetails(aboutDetails.getAboutUs());
                    }
                });
    }

    @Override
    public void fetchDoctorDetails(Activity context) {
        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);
        service.getDoctorDetails()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DoctorDetails>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(DoctorDetails doctorDetailsList) {
                        mView.displayDoctorDetails(doctorDetailsList.getDoctors());
                    }
                });
    }
}
