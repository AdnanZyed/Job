package com.example.job;

import java.util.List;

public class JobResponse {
    private boolean status;
    private List<Job> data;

    public boolean isStatus() {
        return status;
    }

    public List<Job> getData() {
        return data;
    }
}
