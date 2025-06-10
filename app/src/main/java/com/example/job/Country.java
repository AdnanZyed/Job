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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrefixNumber() {
        return prefixNumber;
    }

    public void setPrefixNumber(String prefixNumber) {
        this.prefixNumber = prefixNumber;
    }

    public String getCountryImage() {
        return countryImage;
    }

    public void setCountryImage(String countryImage) {
        this.countryImage = countryImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
