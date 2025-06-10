package com.example.job;

import com.google.gson.annotations.SerializedName;

public class Certification {
    @SerializedName("id")
    private int id;

    @SerializedName("abbreviation")
    private String abbreviation;

    @SerializedName("name")
    private String name;
}