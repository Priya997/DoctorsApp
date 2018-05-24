package com.priyankaj.doctorsapp.apis;

import com.priyankaj.doctorsapp.model.AboutDetails;
import com.priyankaj.doctorsapp.model.CategoryDetails;
import com.priyankaj.doctorsapp.model.DoctorDetails;
import com.priyankaj.doctorsapp.model.VisionDetails;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Vibhuti on 5/14/2018.
 */

public interface DoctorDataService {

    String SERVICE_ENDPOINT = "http://getfitgym.in";

    @GET("/dr/category")
    Call<CategoryDetails> getCategoryDetails();

    @GET("/dr/doctor")
    Call<DoctorDetails> getDoctorDetails();


    @GET("/dr/vision")
    Call<VisionDetails> getVisionDetails();

    @GET("/dr/about")
    Call<AboutDetails> getAboutDetails();

    /*@POST("/dr/insert")
    Observable<String> sendFormData(@Body AppointmentDetailsRequest appointmentDetailsRequest);*/

    @POST("/dr/insert")
    @FormUrlEncoded
    Call<String> sendFormData(@Field("mobile") String mobile,
                                    @Field("date") String date,
                                    @Field("name") String name,
                                    @Field("time") String time,
                                    @Field("regdate") String regdate,
                                    @Field("remarks") String remarks,
                                    @Field("doctorid") String doctorid);
}
