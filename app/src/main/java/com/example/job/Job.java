package com.example.job;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a job posting with detailed information.
 */
public class Job {

    private String title;
    private String company;
    private String category;
    private double salary;
    private String time;
    private String description;
    private String expire;
    private String pureCode;
    private int views;
    private int years;
    private int remainingDays;
    private List<String> skills;

    public Job(String title, String company, String category, double salary, String time,
               String description, String expire, String pureCode, int views,
               int years, int remainingDays, List<String> skills) {
        this.title = title;
        this.company = company;
        this.category = category;
        this.salary = salary;
        this.time = time;
        this.description = description;
        this.expire = expire;
        this.pureCode = pureCode;
        this.views = views;
        this.years = years;
        this.remainingDays = remainingDays;
        this.skills = skills;
    }

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getPureCode() {
        return pureCode;
    }

    public void setPureCode(String pureCode) {
        this.pureCode = pureCode;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", category='" + category + '\'' +
                ", salary=" + salary +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", expire=" + expire +
                ", pureCode='" + pureCode + '\'' +
                ", views=" + views +
                ", years=" + years +
                ", remainingDays=" + remainingDays +
                ", skills=" + skills +
                '}';
    }
}
