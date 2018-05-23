package com.priyankaj.doctorsapp.apis;

import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.DoctorDetails;
import com.priyankaj.doctorsapp.model.VisionDetails;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
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

    /*@POST("/dr/insert")
    Observable<String> sendFormData(@Body AppointmentDetailsRequest appointmentDetailsRequest);*/

    @POST("/dr/insert")
    @FormUrlEncoded
    Observable<String> sendFormData(@Field("mobile") String mobile,
                                    @Field("date") String date,
                                    @Field("name") String name,
                                    @Field("time") String time,
                                    @Field("regdate") String regdate,
                                    @Field("remarks") String remarks,
                                    @Field("doctorid") String doctorid);
}
