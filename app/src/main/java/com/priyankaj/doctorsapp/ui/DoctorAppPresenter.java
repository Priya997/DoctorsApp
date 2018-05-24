package com.priyankaj.doctorsapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.apis.DoctorDataService;
import com.priyankaj.doctorsapp.apis.ServiceFactory;
import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.AppointmentDetailsRequest;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.DoctorDetails;
import com.priyankaj.doctorsapp.model.VisionDetails;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vibhuti on 5/9/2018.
 */

public class DoctorAppPresenter implements DoctorAppContract.Presenter {

    private DoctorAppContract.View mView;

    public DoctorAppPresenter(DoctorAppContract.View view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start(@Nullable Bundle extras) {

    }

    @Override
    public void destroy() {

    }

    /**
     * Fetch the doctor category details
     * @param context
     */
    @Override
    public void fetchCategoryDetails(final Activity context) {

        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);
            service.getCategoryDetails().enqueue(new Callback<CategoryDetails>() {
                @Override
                public void onResponse(Call<CategoryDetails> call, Response<CategoryDetails> response) {
                    int statusCode = response.code();
                    ArrayList<CategoryDetails.Category> strresponse = response.body().getCategory();
                    mView.displayCategoryDetails(strresponse);
                }

                @Override
                public void onFailure(Call<CategoryDetails> call, Throwable t) {
                    mView.fetchDataFailure(context.getResources().getString(R.string.category_error_message));
                }
            });
    }

    /**
     * Fetch details for app vision
     * @param context
     */
    @Override
    public void fetchVisionDetails(final Activity context){
        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);

            service.getVisionDetails().enqueue(new Callback<VisionDetails>() {
                @Override
                public void onResponse(Call<VisionDetails> call, Response<VisionDetails> response) {
                    mView.displayVisionDetails(response.body().getVision());
                }

                @Override
                public void onFailure(Call<VisionDetails> call, Throwable t) {
                    mView.fetchDataFailure(context.getResources().getString(R.string.vision_error_message));
                }
            });
    }

    /**
     * Fetch details for about app
     * @param context
     */
    @Override
    public void fetchAboutDetails(final Activity context) {
        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);
            service.getAboutDetails().enqueue(new Callback<AboutDetails>() {
                @Override
                public void onResponse(Call<AboutDetails> call, Response<AboutDetails> response) {
                    mView.displayAboutDetails(response.body().getAboutUs());
                }

                @Override
                public void onFailure(Call<AboutDetails> call, Throwable t) {
                    mView.fetchDataFailure(context.getResources().getString(R.string.about_error_message));
                }
            });
    }

    /**
     * Fetch details for doctor
     * @param context
     */
    @Override
    public void fetchDoctorDetails(final Activity context) {
        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);

            service.getDoctorDetails().enqueue(new Callback<DoctorDetails>() {
                @Override
                public void onResponse(Call<DoctorDetails> call, Response<DoctorDetails> response) {
                    mView.displayDoctorDetails(response.body().getDoctors());
                }

                @Override
                public void onFailure(Call<DoctorDetails> call, Throwable t) {
                    mView.fetchDataFailure(context.getResources().getString(R.string.doctor_error_message));
                }
            });
    }

    /**
     * Send appointment details to server
     * @param appointmentDetailsRequest
     */
    @Override
    public void sendFormData(final Activity context, AppointmentDetailsRequest appointmentDetailsRequest) {
        DoctorDataService service = ServiceFactory.createRetrofitService(DoctorDataService.class, DoctorDataService.SERVICE_ENDPOINT);
            service.sendFormData(appointmentDetailsRequest.getMobile(),
                    appointmentDetailsRequest.getDate(),
                    appointmentDetailsRequest.getName(),
                    appointmentDetailsRequest.getTime(),
                    appointmentDetailsRequest.getRegdate(),
                    appointmentDetailsRequest.getRemarks(),
                    appointmentDetailsRequest.getDoctorId()).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    mView.showformDisplaySuccess(response.body().toString());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    mView.showformDisplayFaliure(context.getResources().getString(R.string.send_appointment_details_error_message));
                }
            });
    }

    @Override
    public void fetchDoctorPersonalDetails(Activity context) {

    }
}
