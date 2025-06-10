package com.example.job;

import com.google.gson.annotations.SerializedName;

public class BusinessMan {
    @SerializedName("id")
    private int id;

    @SerializedName("business_name")
    private String businessName;

    @SerializedName("employee_no")
    private String employeeNo;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("intro_phone")
    private String introPhone;

    @SerializedName("website")
    private String website;

    @SerializedName("bio")
    private String bio;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("cover_url")
    private String coverUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroPhone() {
        return introPhone;
    }

    public void setIntroPhone(String introPhone) {
        this.introPhone = introPhone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
