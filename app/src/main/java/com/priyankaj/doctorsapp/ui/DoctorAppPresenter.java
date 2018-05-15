package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.priyankaj.doctorsapp.apis.DoctorDataService;
import com.priyankaj.doctorsapp.apis.ServiceFactory;
import com.priyankaj.doctorsapp.model.DoctorAppDetails;

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
    public void fetchDoctorAppDetails(Activity context) {

        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);
        service.getDoctorDetails()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<DoctorAppDetails>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(DoctorAppDetails doctorAppDetails) {
                            Log.d("doctor details",doctorAppDetails.getAppointment().get(0).getAppointments_id());
                            mView.displayDoctorDetails(doctorAppDetails);
                        }
                    });

    }
}
