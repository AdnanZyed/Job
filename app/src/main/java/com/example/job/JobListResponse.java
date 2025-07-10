package com.example.job;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JobListResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private List<Job> data;

    public boolean isStatus() {
        return status;
    }

    public List<Job> getData() {
        return data;
    }
}
