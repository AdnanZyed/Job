package com.example.job;

import com.google.gson.annotations.SerializedName;


public class Job {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("employment_type")
    private String employmentType;

    @SerializedName("work_field_id")//في التفاصيل
    private int workFieldId;

    @SerializedName("work_place")
    private String workPlace;

    @SerializedName("country_of_employment")//في التفاصيل
    private Country countryOfEmployment;

    @SerializedName("salary")
    private String salary;

    @SerializedName("salary_show")//في التفاصيل
    private int salaryShow;

    @SerializedName("work_experience")//في التفاصيل وهي المدة
    private int workExperience;

    @SerializedName("job_valid_unite")
    private String jobValidUnite;

    @SerializedName("summary")//--------------------------------
    private String summary;

    @SerializedName("nationality_prefrence")//في التفاصيل تحت
    private Country nationalityPreference;

    @SerializedName("country_of_residence")//في التفاصيل
    private Country countryOfResidence;

    @SerializedName("gender_perfrence")//في التفاصيل
    private String genderPreference;

    @SerializedName("request_vedio")//--------------------------------
    private int requestVideo;

    @SerializedName("question")//--------------------------------
    private String question;

    @SerializedName("status")//--------------------------------
    private int status;

    @SerializedName("business_man_id")//--------------------------------
    private int businessManId;

    @SerializedName("currency_id")//--------------------------------
    private Integer currencyId;

    @SerializedName("pay_status")//--------------------------------
    private int payStatus;

    @SerializedName("education_level_id")
    private int educationLevelId;

    @SerializedName("education_feild_id")
    private int educationFieldId;

    @SerializedName("certification_id")
    private int certificationId;

    @SerializedName("file_description")
    private String fileDescription;

    @SerializedName("country_of_graduation")//--------------------------------
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

    @SerializedName("business_man")//--------------------------------
    private BusinessMan businessMan;

    @SerializedName("work_field")//في التفاصيل
    private WorkField workField;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public int getWorkFieldId() {
        return workFieldId;
    }

    public void setWorkFieldId(int workFieldId) {
        this.workFieldId = workFieldId;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public Country getCountryOfEmployment() {
        return countryOfEmployment;
    }

    public void setCountryOfEmployment(Country countryOfEmployment) {
        this.countryOfEmployment = countryOfEmployment;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getSalaryShow() {
        return salaryShow;
    }

    public void setSalaryShow(int salaryShow) {
        this.salaryShow = salaryShow;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public String getJobValidUnite() {
        return jobValidUnite;
    }

    public void setJobValidUnite(String jobValidUnite) {
        this.jobValidUnite = jobValidUnite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Country getNationalityPreference() {
        return nationalityPreference;
    }

    public void setNationalityPreference(Country nationalityPreference) {
        this.nationalityPreference = nationalityPreference;
    }

    public Country getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(Country countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(String genderPreference) {
        this.genderPreference = genderPreference;
    }

    public int getRequestVideo() {
        return requestVideo;
    }

    public void setRequestVideo(int requestVideo) {
        this.requestVideo = requestVideo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBusinessManId() {
        return businessManId;
    }

    public void setBusinessManId(int businessManId) {
        this.businessManId = businessManId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public int getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(int educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    public int getEducationFieldId() {
        return educationFieldId;
    }

    public void setEducationFieldId(int educationFieldId) {
        this.educationFieldId = educationFieldId;
    }

    public int getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(int certificationId) {
        this.certificationId = certificationId;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public Country getCountryOfGraduation() {
        return countryOfGraduation;
    }

    public void setCountryOfGraduation(Country countryOfGraduation) {
        this.countryOfGraduation = countryOfGraduation;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }

    public int getApplicants() {
        return applicants;
    }

    public void setApplicants(int applicants) {
        this.applicants = applicants;
    }

    public int getWatchesCount() {
        return watchesCount;
    }

    public void setWatchesCount(int watchesCount) {
        this.watchesCount = watchesCount;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isApplied() {
        return isApplied;
    }

    public void setApplied(boolean applied) {
        isApplied = applied;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public EducationField getEducationField() {
        return educationField;
    }

    public void setEducationField(EducationField educationField) {
        this.educationField = educationField;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public ExperienceYear getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(ExperienceYear experienceYear) {
        this.experienceYear = experienceYear;
    }

    public BusinessMan getBusinessMan() {
        return businessMan;
    }

    public void setBusinessMan(BusinessMan businessMan) {
        this.businessMan = businessMan;
    }

    public WorkField getWorkField() {
        return workField;
    }

    public void setWorkField(WorkField workField) {
        this.workField = workField;
    }
}
