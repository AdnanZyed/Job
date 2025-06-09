package com.example.job;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://fursaty.kicklance.com/";

    private static final String TOKEN = "146|NmNVeKL3hmU9GJGrSf3rzFYDlUAGSM3FOIrJc3pr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvJobs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getAllJobs(TOKEN).enqueue(new Callback<JobResponse>() {
            @Override
            public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {
                    List<Job> jobs = response.body().getData();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        recyclerView.setAdapter(new JobAdapter(MainActivity.this, jobs));
                    }

                } else {

                    Toast.makeText(MainActivity.this, "No jobs found", Toast.LENGTH_SHORT).show();
                    Log.e("Adnan", "Response error: " + response.code());
                }

            }
            @Override
            public void onFailure(Call<JobResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("TAG", "Network failure: ", t);
            }
        });

    }
}
