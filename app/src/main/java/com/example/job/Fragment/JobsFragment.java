package com.example.job.Fragment;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.job.Adapter.JobAdapter;
import com.example.job.API.ApiService;
import com.example.job.models.JobListResponse;
import com.example.job.R;
import com.example.job.API.RetrofitClient;
import com.example.job.models.Job;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobsFragment extends Fragment {

    private static final String TOKEN = "146|NmNVeKL3hmU9GJGrSf3rzFYDlUAGSM3FOIrJc3pr";
    private RecyclerView recyclerView;
    private List<Job> currentJobs = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);

        recyclerView = view.findViewById(R.id.rvJobs);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        String authHeader = "Bearer " + TOKEN;

        apiService.getAllJobs(authHeader).enqueue(new Callback<JobListResponse>() {
            @Override
            public void onResponse(Call<JobListResponse> call, Response<JobListResponse> response) {
                if (!isAdded() || getContext() == null) {
                    return;
                }

                if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {
                    List<Job> jobs = response.body().getData();

                    if (jobs != null && !jobs.isEmpty()) {
                        currentJobs.clear();
                        currentJobs.addAll(jobs);

                        recyclerView.setAdapter(new JobAdapter(getContext(), jobs));
                    } else {
                        Toast.makeText(getContext(), "No jobs found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Failed to fetch jobs: " + response.code(), Toast.LENGTH_SHORT).show();
                    Log.e("JobsFragment", "Response error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<JobListResponse> call, Throwable t) {
                if (!isAdded() || getContext() == null) {
                    return;
                }
                Toast.makeText(getContext(), "Network Failure: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("JobsFragment", "Network failure: ", t);
            }
        });

        return view;
    }

    public List<Job> getCurrentJobs() {
        return currentJobs;
    }
}

