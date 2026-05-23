package com.example.job;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.job.Adapter.JobAdapter;
import com.example.job.models.Job;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class JobSearchBottomSheet extends BottomSheetDialogFragment {

    private RecyclerView recyclerView;
    private EditText etSearch;
    private JobAdapter adapter;
    private List<Job> jobList;

    public JobSearchBottomSheet(List<Job> jobs) {
        this.jobList = jobs != null ? jobs : new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_job_search_bottom_sheet, container, false);

        recyclerView = view.findViewById(R.id.rvSearchJobs);
        etSearch = view.findViewById(R.id.etSearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new JobAdapter(getContext(), new ArrayList<>(jobList));
        recyclerView.setAdapter(adapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterJobs(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    private void filterJobs(String query) {
        List<Job> filteredList = new ArrayList<>();
        for (Job job : jobList) {
            if (job.getTitle() != null && job.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(job);
            }
        }
        adapter.updateList(filteredList);
    }
}
