package com.example.job;

import com.google.gson.annotations.SerializedName;

public class Job {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("employment_type")
    private String employmentType;

    @SerializedName("work_field_id")
    private int workFieldId;

    @SerializedName("work_place")
    private String workPlace;

    @SerializedName("country_of_employment")
    private Country countryOfEmployment;

    @SerializedName("salary")
    private String salary;

    @SerializedName("salary_show")
    private int salaryShow;

    @SerializedName("work_experience")
    private int workExperience;

    @SerializedName("job_valid_unite")
    private String jobValidUnite;

    @SerializedName("summary")
    private String summary;

    @SerializedName("nationality_prefrence")
    private Country nationalityPreference;

    @SerializedName("country_of_residence")
    private Country countryOfResidence;

    @SerializedName("gender_perfrence")
    private String genderPreference;

    @SerializedName("request_vedio")
    private int requestVideo;

    @SerializedName("question")
    private String question;

    @SerializedName("status")
    private int status;

    @SerializedName("business_man_id")
    private int businessManId;

    @SerializedName("currency_id")
    private Integer currencyId;

    @SerializedName("pay_status")
    private int payStatus;

    @SerializedName("education_level_id")
    private int educationLevelId;

    @SerializedName("education_feild_id")
    private int educationFieldId;

    @SerializedName("certification_id")
    private int certificationId;

    @SerializedName("file_description")
    private String fileDescription;

    @SerializedName("country_of_graduation")
    private Country countryOfGraduation;

    @SerializedName("create_time")
    private String createTime;

    @SerializedName("expire_date")
    private int expireDate;

    @SerializedName("applicants")
    private int applicants;

    @SerializedName("watches_count")
    private int watchesCount;

    @SerializedName("is_favorite")
    private boolean isFavorite;

    @SerializedName("is_applied")
    private boolean isApplied;

    @SerializedName("education_level")
    private EducationLevel educationLevel;

    @SerializedName("education_feild")
    private EducationField educationField;

    @SerializedName("certification")
    private Certification certification;

    @SerializedName("experience_year")
    private ExperienceYear experienceYear;

    @SerializedName("business_man")
    private BusinessMan businessMan;

    @SerializedName("work_field")
    private WorkField workField;

    // Getters فقط لضمان الأمان
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getEmploymentType() { return employmentType; }
    public int getWorkFieldId() { return workFieldId; }
    public String getWorkPlace() { return workPlace; }
    public Country getCountryOfEmployment() { return countryOfEmployment; }
    public String getSalary() { return salary; }
    public int getSalaryShow() { return salaryShow; }
    public int getWorkExperience() { return workExperience; }
    public String getJobValidUnite() { return jobValidUnite; }
    public String getSummary() { return summary; }
    public Country getNationalityPreference() { return nationalityPreference; }
    public Country getCountryOfResidence() { return countryOfResidence; }
    public String getGenderPreference() { return genderPreference; }
    public int getRequestVideo() { return requestVideo; }
    public String getQuestion() { return question; }
    public int getStatus() { return status; }
    public int getBusinessManId() { return businessManId; }
    public Integer getCurrencyId() { return currencyId; }
    public int getPayStatus() { return payStatus; }
    public int getEducationLevelId() { return educationLevelId; }
    public int getEducationFieldId() { return educationFieldId; }
    public int getCertificationId() { return certificationId; }
    public String getFileDescription() { return fileDescription; }
    public Country getCountryOfGraduation() { return countryOfGraduation; }
    public String getCreateTime() { return createTime; }
    public int getExpireDate() { return expireDate; }
    public int getApplicants() { return applicants; }
    public int getWatchesCount() { return watchesCount; }
    public boolean isFavorite() { return isFavorite; }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isApplied() { return isApplied; }
    public EducationLevel getEducationLevel() { return educationLevel; }
    public EducationField getEducationField() { return educationField; }
    public Certification getCertification() { return certification; }
    public ExperienceYear getExperienceYear() { return experienceYear; }
    public BusinessMan getBusinessMan() { return businessMan; }
    public WorkField getWorkField() { return workField; }
}
