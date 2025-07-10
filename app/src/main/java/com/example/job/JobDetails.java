package com.example.job;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JobDetails extends AppCompatActivity {
    private String CountryImage, ImageUrl, CoverUrl, Title, WorkFieldId1, EmploymentType,
            EmployeeNo, CountryOfEmployment, Bio;
    int Id;
    private static final String BASE_URL = "https://fursaty.kicklance.com/";
    private static Retrofit retrofit;
    private TextView linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        if (Intent.ACTION_VIEW.equals(action) && data != null) {
            String path = data.getLastPathSegment();
            try {
                Id = Integer.parseInt(path);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "رابط غير صالح", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
        } else {
            Id = getIntent().getIntExtra("COURSE_ID", -1);
        }

        TextView job_type = findViewById(R.id.job_type);
        TextView work_field = findViewById(R.id.work_field);
        ImageView ImgShare1 = findViewById(R.id.imgShare1);
        ImageView tvCodeImage1 = findViewById(R.id.tvCodeImage1);
        TextView country_of_employment = findViewById(R.id.country_of_employment);
        TextView salary = findViewById(R.id.salary);
        TextView required_experience = findViewById(R.id.required_experience);
        TextView job_description = findViewById(R.id.job_description);
        TextView nationality = findViewById(R.id.nationality);
        ImageView country_image1 = findViewById(R.id.country_image1);
        TextView country_residence = findViewById(R.id.country_residence);
        TextView gender = findViewById(R.id.gender);
        TextView tvTime1 = findViewById(R.id.tvTime1);
        TextView tvJobTitle1 = findViewById(R.id.tvJobTitle1);
        TextView tvCompany1 = findViewById(R.id.tvCompany1);
        TextView tvViews1 = findViewById(R.id.tvViews1);
        TextView WorkFieldId = findViewById(R.id.workFieldId1);

        linearLayout = findViewById(R.id.tvJobTitle1);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobDetails.this, CompanyDetails.class);
                intent.putExtra("CountryImage", CountryImage);
                intent.putExtra("ImageUrl", ImageUrl);
                intent.putExtra("CoverUrl", CoverUrl);
                intent.putExtra("Title", Title);
                intent.putExtra("WorkFieldId1", WorkFieldId1);
                intent.putExtra("EmploymentType", EmploymentType);
                intent.putExtra("EmployeeNo", EmployeeNo);
                intent.putExtra("CountryOfEmployment", CountryOfEmployment);
                intent.putExtra("Bio", Bio);
                startActivity(intent);
            }
        });

        Log.e("Adnan", "Job ID: " + Id);

        ImgShare1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getItemById(Id).enqueue(new Callback<JobDetailResponse>() {
            @Override
            public void onResponse(Call<JobDetailResponse> call, Response<JobDetailResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Job job = response.body().getData();
                    CountryImage = job.getCountryOfResidence() != null ? job.getCountryOfResidence().getCountryImage() : null;
                    ImageUrl = job.getBusinessMan() != null ? job.getBusinessMan().getImageUrl() : null;
                    CoverUrl = job.getBusinessMan() != null ? job.getBusinessMan().getCoverUrl() : null;
                    Title = job.getTitle();
                    WorkFieldId1 = String.valueOf(job.getWorkFieldId());
                    EmploymentType = job.getEmploymentType();
                    EmployeeNo = job.getBusinessMan() != null ? job.getBusinessMan().getEmployeeNo() : null;
                    CountryOfEmployment = job.getCountryOfEmployment() != null ? job.getCountryOfEmployment().getName() : null;
                    Bio = job.getBusinessMan() != null ? job.getBusinessMan().getBio() : null;

                    tvTime1.setText(job.getCreateTime() != null ? job.getCreateTime() : "غير متوفر");
                    tvJobTitle1.setText(job.getTitle() != null ? job.getTitle() : "غير متوفر");
                    tvCompany1.setText(job.getBusinessMan() != null && job.getBusinessMan().getBusinessName() != null
                            ? job.getBusinessMan().getBusinessName() : "غير متوفر");
                    tvViews1.setText(String.valueOf(job.getWatchesCount()));
                    WorkFieldId.setText(String.valueOf(job.getWorkFieldId()));

                    Glide.with(JobDetails.this)
                            .load(ImageUrl != null ? ImageUrl : R.drawable.img_33)
                            .placeholder(R.drawable.img_33)
                            .error(R.drawable.img_33)
                            .into(tvCodeImage1);

                    String countryImageUrl = CountryImage != null ? CountryImage : null;

                    Glide.with(JobDetails.this)
                            .load(countryImageUrl != null ? countryImageUrl : R.drawable.img_country)
                            .placeholder(R.drawable.img_country)
                            .error(R.drawable.img_country)
                            .into(country_image1);

                    job_type.setText(EmploymentType != null ? EmploymentType : "غير متوفر");
                    work_field.setText(job.getWorkField() != null && job.getWorkField().getName() != null
                            ? job.getWorkField().getName() : "غير متوفر");
                    country_of_employment.setText(job.getCountryOfEmployment() != null && job.getCountryOfEmployment().getName() != null
                            ? job.getCountryOfEmployment().getName() : "غير متوفر");
                    salary.setText(job.getSalary() != null ? job.getSalary() : "غير متوفر");
                    required_experience.setText(String.valueOf(job.getWorkExperience()));
                    job_description.setText(job.getSummary() != null ? job.getSummary() : "غير متوفر");
                    nationality.setText(job.getNationalityPreference() != null && job.getNationalityPreference().getName() != null
                            ? job.getNationalityPreference().getName() : "غير متوفر");
                    country_residence.setText(job.getCountryOfResidence() != null && job.getCountryOfResidence().getName() != null
                            ? job.getCountryOfResidence().getName() : "غير متوفر");
                    gender.setText(job.getGenderPreference() != null ? job.getGenderPreference() : "غير متوفر");

                } else {
                    Toast.makeText(JobDetails.this, "Failed to get job details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JobDetailResponse> call, Throwable t) {
                Toast.makeText(JobDetails.this, "Network Failure: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("JobDetails", "Network failure: ", t);
            }
        });
    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(JobDetails.this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.layout_share_bottom_sheet, null);

        String shareLink = "https://fursaty.kicklance.com/job/" + Id;
        String shareMessage = "فرصة عمل: " + Title + "\n\n" + shareLink;

        ImageView btnGmail = bottomSheetView.findViewById(R.id.btnGmail);
        ImageView btnFacebook = bottomSheetView.findViewById(R.id.btnFacebook);
        ImageView btnMessenger = bottomSheetView.findViewById(R.id.btnMessenger);
        ImageView btnWhatsapp = bottomSheetView.findViewById(R.id.btnWhatsapp);
        ImageView btnCopy = bottomSheetView.findViewById(R.id.btnCopy);

        btnGmail.setOnClickListener(v -> {
            shareViaGmail(shareMessage);
            bottomSheetDialog.dismiss();
        });

        btnFacebook.setOnClickListener(v -> {
            shareViaFacebook(shareMessage);
            bottomSheetDialog.dismiss();
        });

        btnMessenger.setOnClickListener(v -> {
            shareViaMessenger(shareMessage);
            bottomSheetDialog.dismiss();
        });

        btnWhatsapp.setOnClickListener(v -> {
            shareViaWhatsapp(shareMessage);
            bottomSheetDialog.dismiss();
        });

        btnCopy.setOnClickListener(v -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Job Link", shareLink);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(JobDetails.this, "تم نسخ الرابط", Toast.LENGTH_SHORT).show();
            bottomSheetDialog.dismiss();
        });

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void shareViaGmail(String message) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.setPackage("com.google.android.gm");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Gmail غير مثبت", Toast.LENGTH_SHORT).show();
        }
    }

    private void shareViaWhatsapp(String message) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.setPackage("com.whatsapp");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "WhatsApp غير مثبت", Toast.LENGTH_SHORT).show();
        }
    }

    private void shareViaFacebook(String message) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.setPackage("com.facebook.katana");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Facebook غير مثبت", Toast.LENGTH_SHORT).show();
        }
    }

    private void shareViaMessenger(String message) {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.setPackage("com.facebook.orca");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Messenger غير مثبت", Toast.LENGTH_SHORT).show();
        }
    }
}