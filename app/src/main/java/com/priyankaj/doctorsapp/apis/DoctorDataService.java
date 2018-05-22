package com.priyankaj.doctorsapp.apis;

import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.AppointmentDetailsRequest;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.DoctorDetails;
import com.priyankaj.doctorsapp.model.VisionDetails;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by Vibhuti on 5/14/2018.
 */

public interface DoctorDataService {

    String SERVICE_ENDPOINT = "http://getfitgym.in";

    @GET("/dr/category")
    Observable<CategoryDetails> getCategoryDetails();

    @GET("/dr/doctor")
    Observable<DoctorDetails> getDoctorDetails();


    @GET("/dr/vision")
    Observable<VisionDetails> getVisionDetails();

    @GET("/dr/about")
    Observable<AboutDetails> getAboutDetails();

    @POST("/dr/insert")
    Observable<String> sendFormData(@Body AppointmentDetailsRequest appointmentDetailsRequest);
}
