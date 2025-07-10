package com.example.job;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("id")
    private int id;

    @SerializedName("code")
    private String code;

    @SerializedName("prefix_number")
    private String prefixNumber;

    @SerializedName("country_image")
    private String countryImage;

    @SerializedName("name")
    private String name;

    public int getId() { return id; }
    public String getCode() { return code; }
    public String getPrefixNumber() { return prefixNumber; }
    public String getCountryImage() { return countryImage; }
    public String getName() { return name; }
}
