package com.example.job;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
public interface ApiService {
    @GET("ar/api/job-seeker/all-jobs")
    Call<JobResponse> getAllJobs(@Header("Authorization") String token);
    @GET("ar/api/job-seeker/job-details/{id}")
    Call<JobResponse> getItemById(@Path("id") int id);

//    @GET("item/{id}")
//    Call<JobResponse> getItemById(@Path("id") int id);

}


