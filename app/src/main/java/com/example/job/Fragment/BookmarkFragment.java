package com.example.job.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.job.Adapter.JobAdapter;
import com.example.job.API.ApiService;
import com.example.job.models.JobListResponse;
import com.example.job.R;
import com.example.job.models.Job;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookmarkFragment extends Fragment {
    private static final String BASE_URL = "https://fursaty.kicklance.com/";
    private static final String TOKEN = "Bearer 146|NmNVeKL3hmU9GJGrSf3rzFYDlUAGSM3FOIrJc3pr";
    private RecyclerView recyclerView;
    private JobAdapter jobAdapter;
    private List<Job> favoriteJobs = new ArrayList<>();
    private static Retrofit retrofit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);

        recyclerView = view.findViewById(R.id.rvFavorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        jobAdapter = new JobAdapter(requireContext(), favoriteJobs);
        recyclerView.setAdapter(jobAdapter);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getFavoriteJobs(TOKEN).enqueue(new Callback<JobListResponse>() {
            @Override
            public void onResponse(Call<JobListResponse> call, Response<JobListResponse> response) {
                if (!isAdded() || getContext() == null) return;

                if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {
                    favoriteJobs.clear();
                    favoriteJobs.addAll(response.body().getData());
                    jobAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "No favorites found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JobListResponse> call, Throwable t) {
                if (!isAdded() || getContext() == null) return;

                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
