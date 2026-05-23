package com.example.job.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.job.API.ApiService;
import com.example.job.ActionBottomSheet;
import com.example.job.Adapter.JobAdapter;
import com.example.job.R;
import com.example.job.models.Job;
import com.example.job.models.JobListResponse;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompanyDetails extends AppCompatActivity {
    private TextView tvCompanyName, tvCompanyId, tvCompanyDescription, read_mor_btn,
            tvBusinessType, tvEmployeeCount, tvCountry;
    private ImageView profile_image, company_image, country_image;

    private static final String BASE_URL = "https://fursaty.kicklance.com/";
    private static final String TOKEN = "146|NmNVeKL3hmU9GJGrSf3rzFYDlUAGSM3FOIrJc3pr";
    private RecyclerView recyclerView;
    private static Retrofit retrofit;
    private List<Job> currentJobs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);
        tvCompanyName = findViewById(R.id.workField2);
        profile_image = findViewById(R.id.company_image_profile);
        company_image = findViewById(R.id.company_image);
        tvCompanyId = findViewById(R.id.id_wark_filde);
        tvBusinessType = findViewById(R.id.businessTypeText);
        tvEmployeeCount = findViewById(R.id.employeeCountText);
        country_image = findViewById(R.id.country_image);
        tvCountry = findViewById(R.id.countryText);
        tvCompanyDescription = findViewById(R.id.companyDescriptionText);
        read_mor_btn = findViewById(R.id.read_mor_btn);


        String CountryImage = getIntent().getStringExtra("CountryImage");
        String Phone = getIntent().getStringExtra("Phone");
        String ImageUrl = getIntent().getStringExtra("ImageUrl");
        String CoverUrl = getIntent().getStringExtra("CoverUrl");
        String Title = getIntent().getStringExtra("Title");
        String WorkFieldId1 = getIntent().getStringExtra("WorkFieldId1");
        String EmploymentType = getIntent().getStringExtra("EmploymentType");
        String EmployeeNo = getIntent().getStringExtra("EmployeeNo");
        String CountryOfEmployment = getIntent().getStringExtra("CountryOfEmployment");
        String Bio = getIntent().getStringExtra("Bio");

        ActionBottomSheet bottomSheet = ActionBottomSheet.newInstance(Phone);
        bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());

        Glide.with(this)
                .load(CountryImage != null ? CountryImage : R.drawable.img_country)
                .placeholder(R.drawable.img_country)
                .error(R.drawable.img_country)
                .into(country_image);

        Glide.with(this)
                .load(ImageUrl != null ? ImageUrl : R.drawable.img_country)
                .placeholder(R.drawable.img_country)
                .error(R.drawable.img_country)
                .into(company_image);

        Glide.with(this)
                .load(CoverUrl != null ? CoverUrl : R.drawable.img_country)
                .placeholder(R.drawable.img_country)
                .error(R.drawable.img_country)
                .into(profile_image);

        tvCompanyName.setText(Title != null ? Title : "N/A");
        tvCountry.setText(CountryOfEmployment != null ? CountryOfEmployment : "N/A");
        tvBusinessType.setText(EmploymentType != null ? EmploymentType : "N/A");
        tvEmployeeCount.setText(EmployeeNo != null ? EmployeeNo : "N/A");
        tvCompanyId.setText(WorkFieldId1 != null ? WorkFieldId1 : "N/A");
        tvCompanyDescription.setText(Bio != null ? Bio : "N/A");

        read_mor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View bottomSheetView = LayoutInflater.from(CompanyDetails.this)
                        .inflate(R.layout.layout_bio_bottom_sheet, null);
                TextView bioText = bottomSheetView.findViewById(R.id.text_bio);

                bioText.setText(Bio != null ? Bio : "No Bio Available");

                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CompanyDetails.this);
                bottomSheetDialog.setContentView(bottomSheetView);


                bottomSheetDialog.show();
            }
        });

        /// /////////////////////////////////
        View bottomSheetView = LayoutInflater.from(CompanyDetails.this)
                .inflate(R.layout.bottom_sheet_actions, null);

        TextView hiddenPhoneText = bottomSheetView.findViewById(R.id.hiddenPhoneText);
        hiddenPhoneText.setText(Phone);

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CompanyDetails.this);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();


        /// /////////////////////////////
        recyclerView = findViewById(R.id.rvJobs1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        String authHeader = "Bearer " + TOKEN;

        apiService.getAllJobs(authHeader).enqueue(new Callback<JobListResponse>() {
            @Override
            public void onResponse(Call<JobListResponse> call, Response<JobListResponse> response) {


                if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {
                    List<Job> jobs = response.body().getData();

                    if (jobs != null && !jobs.isEmpty()) {
                        currentJobs.clear();
                        currentJobs.addAll(jobs);

                        recyclerView.setAdapter(new JobAdapter(CompanyDetails.this, jobs));
                    } else {
                        Toast.makeText(CompanyDetails.this, "No jobs found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CompanyDetails.this, "Failed to fetch jobs: " + response.code(), Toast.LENGTH_SHORT).show();
                    Log.e("JobsFragment", "Response error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<JobListResponse> call, Throwable t) {

                Toast.makeText(CompanyDetails.this, "Network Failure: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("JobsFragment", "Network failure: ", t);
            }
        });

    }


}

