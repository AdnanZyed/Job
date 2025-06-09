package com.example.job;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {
    @GET("ar/api/job-seeker/all-jobs")
    Call<JobResponse> getAllJobs(@Header("Authorization") String token);


}


