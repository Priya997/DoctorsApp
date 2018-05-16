package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.priyankaj.doctorsapp.apis.DoctorDataService;
import com.priyankaj.doctorsapp.apis.ServiceFactory;
import com.priyankaj.doctorsapp.model.CategoryDetails;

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
}
