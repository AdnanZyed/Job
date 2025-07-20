package com.example.job;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface ApiService {
    @GET("api/job-seeker/all-jobs")
    Call<JobListResponse> getAllJobs(@Header("Authorization") String authHeader);
    @GET("api/job-seeker/job-details/{id}")
    Call<JobDetailResponse> getItemById(@Path("id") int id);
    @POST("api/job-seeker/jobs/{job_id}/mark-favorite")
    Call<ResponseBody> markJobAsFavorite(
            @Header("Authorization") String token,
            @Path("job_id") int jobId
    );
    @GET("api/job-seeker/favorite-jobs")
    Call<JobListResponse> getFavoriteJobs(@Header("Authorization") String token);
    @GET("api/faqs")
    Call<FursaResponse> getFursaData();

    @GET("api/policies")
    Call<PrivacyResponse> getPrivacyData();
    @GET("api/all-companies")
    Call<FilterResponse> getFilters();
    @GET("jobs/{id}")
    Call<Job> getJobDetails(@Path("id") String jobId);
    @GET("api/job/{id}")
    Call<JobDetailResponse> getItemShareById(@Path("id") int jobId);

    @FormUrlEncoded
    @POST("api/job-seeker/jobs/applied")
    Call<Void> applyForJob(
            @Field("job_id") String jobId,
            @Field("user_id") String userId
    );
//    @GET("api/user/language")
//    Call<LanguageResponse> getLanguagePreference();
//
//    @POST("api/user/language/update")
//    Call<ResponseBody> updateLanguagePreference(@Body LanguageRequest request);



}


