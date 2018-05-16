package com.priyankaj.doctorsapp.apis;

import com.priyankaj.doctorsapp.model.CategoryDetails;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Vibhuti on 5/14/2018.
 */

public interface DoctorDataService {

    String SERVICE_ENDPOINT = "http://getfitgym.in";

    @GET("/dr/category")
    Observable<CategoryDetails> getCategoryDetails();

}
