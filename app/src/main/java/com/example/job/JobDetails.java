package com.example.job;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JobDetails extends AppCompatActivity {
    int Id;

    private static final String BASE_URL = "https://fursaty.kicklance.com/";

    private static Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

         TextView job_type=findViewById(R.id.job_type);
         TextView work_field=findViewById(R.id.work_field);
         TextView country_of_employment=findViewById(R.id.country_of_employment);
         TextView salary=findViewById(R.id.salary);
         TextView required_experience=findViewById(R.id.required_experience);
         TextView job_description=findViewById(R.id.job_description);
         TextView nationality=findViewById(R.id.nationality);
         TextView country_residence=findViewById(R.id.country_residence);
         TextView gender=findViewById(R.id.gender);
         TextView tvTime1=findViewById(R.id.tvTime1);
         TextView tvJobTitle1=findViewById(R.id.tvJobTitle1);
         TextView tvCompany1=findViewById(R.id.tvCompany1);
         TextView tvViews1=findViewById(R.id.tvViews1);




         Id = getIntent().getIntExtra("COURSE_ID", -1);

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            ApiService apiService = retrofit.create(ApiService.class);



            apiService.getItemById(Id).enqueue(new Callback<JobResponse>() {
                @Override
                public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        JobResponse item = response.body();
                        tvTime1.setText(item.getData().get(0).getCreateTime());
                        tvJobTitle1.setText(item.getData().get(0).getTitle());
                        tvCompany1.setText(item.getData().get(0).getWorkPlace());
                        tvViews1.setText(item.getData().get(0).getWatchesCount());
                        job_type.setText(item.getData().get(0).getEmploymentType());
                        work_field.setText(item.getData().get(0).getWorkField().toString());
                        country_of_employment.setText(item.getData().get(0).getCountryOfEmployment().toString());
                        salary.setText(item.getData().get(0).getSalary().toString());
                        required_experience.setText(item.getData().get(0).getWorkExperience());
                        job_description.setText(item.getData().get(0).getFileDescription());
                        nationality.setText(item.getData().get(0).getNationalityPreference().getName());
                        country_residence.setText(item.getData().get(0).getCountryOfResidence().getName());
                        gender.setText(item.getData().get(0).getGenderPreference());

                    } else {

                        Toast.makeText(JobDetails.this, "Faild", Toast.LENGTH_SHORT).show();
                    }

                }
                @Override
                public void onFailure(Call<JobResponse> call, Throwable t) {
                    Toast.makeText(JobDetails.this, "Failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("TAG", "Network failure: ", t);
                }
            });


        }

    }

