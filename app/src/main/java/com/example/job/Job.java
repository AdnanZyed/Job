package com.example.job;

//package com.example.job;
//import java.util.List;
//public class Job {
//
//    private String title;
//    private String company;
//    private String category;
//    private double salary;
//    private String time;
//    private String description;
//    private String expire;
//    private String pureCode;
//    private int views;
//    private int years;
//    private int remainingDays;
//    private List<String> skills;
//    public Job(String title, String company, String category, double salary, String time,
//               String description, String expire, String pureCode, int views,
//               int years, int remainingDays, List<String> skills) {
//
//        this.title = title;
//        this.company = company;
//        this.category = category;
//        this.salary = salary;
//        this.time = time;
//        this.description = description;
//        this.expire = expire;
//        this.pureCode = pureCode;
//        this.views = views;
//        this.years = years;
//        this.remainingDays = remainingDays;
//        this.skills = skills;
//
//    }
//
//
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getExpire() {
//        return expire;
//    }
//
//    public void setExpire(String expire) {
//        this.expire = expire;
//    }
//
//    public String getPureCode() {
//        return pureCode;
//    }
//
//    public void setPureCode(String pureCode) {
//        this.pureCode = pureCode;
//    }
//
//    public int getViews() {
//        return views;
//    }
//
//    public void setViews(int views) {
//        this.views = views;
//    }
//
//    public int getYears() {
//        return years;
//    }
//
//    public void setYears(int years) {
//        this.years = years;
//    }
//
//    public int getRemainingDays() {
//        return remainingDays;
//    }
//
//    public void setRemainingDays(int remainingDays) {
//        this.remainingDays = remainingDays;
//    }
//
//    public List<String> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<String> skills) {
//        this.skills = skills;
//    }
//
//    @Override
//    public String toString() {
//        return "Job{" +
//                "title='" + title + '\'' +
//                ", company='" + company + '\'' +
//                ", category='" + category + '\'' +
//                ", salary=" + salary +
//                ", time='" + time + '\'' +
//                ", description='" + description + '\'' +
//                ", expire=" + expire +
//                ", pureCode='" + pureCode + '\'' +
//                ", views=" + views +
//                ", years=" + years +
//                ", remainingDays=" + remainingDays +
//                ", skills=" + skills +
//                '}';
//    }
//}
public class Job {
    private String from_date;
    private String to_date;
    private String country_of_graduation;
    private String country_of_residence;
    private String work_field_id;
    private String title;
    private String work_place;
    private String gender_perfrence;
    private String education_level_id;
    private String work_experience;
    private String business_man_id;

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String getCountry_of_graduation() {
        return country_of_graduation;
    }

    public void setCountry_of_graduation(String country_of_graduation) {
        this.country_of_graduation = country_of_graduation;
    }

    public String getCountry_of_residence() {
        return country_of_residence;
    }

    public void setCountry_of_residence(String country_of_residence) {
        this.country_of_residence = country_of_residence;
    }

    public String getWork_field_id() {
        return work_field_id;
    }

    public void setWork_field_id(String work_field_id) {
        this.work_field_id = work_field_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public String getGender_perfrence() {
        return gender_perfrence;
    }

    public void setGender_perfrence(String gender_perfrence) {
        this.gender_perfrence = gender_perfrence;
    }

    public String getEducation_level_id() {
        return education_level_id;
    }

    public void setEducation_level_id(String education_level_id) {
        this.education_level_id = education_level_id;
    }

    public String getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(String work_experience) {
        this.work_experience = work_experience;
    }

    public String getBusiness_man_id() {
        return business_man_id;
    }

    public void setBusiness_man_id(String business_man_id) {
        this.business_man_id = business_man_id;
    }
}
