package com.example.job.models;

import com.google.gson.annotations.SerializedName;

public class Certification {
    @SerializedName("id")
    private int id;

    @SerializedName("abbreviation")
    private String abbreviation;

    @SerializedName("name")
    private String name;

    public int getId() { return id; }
    public String getAbbreviation() { return abbreviation; }
    public String getName() { return name; }
}
