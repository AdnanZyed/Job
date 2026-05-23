package com.example.job.models;

import com.google.gson.annotations.SerializedName;

public class ExperienceYear {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public int getId() { return id; }
    public String getName() { return name; }
}
