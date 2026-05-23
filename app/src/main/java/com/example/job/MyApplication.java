package com.example.job;

import android.app.Application;

import com.example.job.API.RetrofitClient;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient.init(getApplicationContext());
       // , "Bearer 146|NmNVeKL3hmU9GJGrSf3rzFYDlUAGSM3FOIrJc3pr"
    }
}
