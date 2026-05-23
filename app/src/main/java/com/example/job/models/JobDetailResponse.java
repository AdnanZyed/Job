package com.example.job.models;

import com.google.gson.annotations.SerializedName;

public class JobDetailResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private Job data;

    public boolean isStatus() {
        return status;
    }

    public Job getData() {
        return data;
    }
}
