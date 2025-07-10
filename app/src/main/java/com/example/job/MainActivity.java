package com.example.job;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;


    JobsFragment jobsFragment = new JobsFragment();
    BookmarkFragment bookmarkFragment = new BookmarkFragment();
    SettingFragment settingFragment = new SettingFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    Fragment activeFragment = jobsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView Notification_BTN  =findViewById(R.id.notification_ic_btn);
        ImageView filterIc = findViewById(R.id.filter_ic);

        filterIc.setOnClickListener(v -> {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://fursaty.kicklance.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiService api = retrofit.create(ApiService.class);
            Call<FilterResponse> call = api.getFilters();

            call.enqueue(new Callback<FilterResponse>() {
                @Override
                public void onResponse(Call<FilterResponse> call, Response<FilterResponse> response) {
                    if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {
                        showFilterBottomSheet(response.body().getData());
                    } else {
                        Toast.makeText(getApplicationContext(), "فشل في جلب البيانات", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<FilterResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "خطأ: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });



        findViewById(R.id.search_ic).setOnClickListener(v -> {
            if (jobsFragment != null && jobsFragment.getCurrentJobs() != null) {
                JobSearchBottomSheet bottomSheet = new JobSearchBottomSheet(jobsFragment.getCurrentJobs());
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
        Notification_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.notification_settings_sheet, null);
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFragment, jobsFragment)
                .commit();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.jobs);


    }
    private void showFilterBottomSheet(List<FilterItem> filterItems) {
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_filter, null);
        RecyclerView recyclerView = view.findViewById(R.id.filterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FilterAdapter adapter = new FilterAdapter(filterItems, item -> {
            Toast.makeText(this, "اخترت: " + item.getName(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);

        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        dialog.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        int itemId = item.getItemId();

        if (itemId == R.id.jobs) {
            selectedFragment = jobsFragment;

        } else if (itemId == R.id.bookmark) {
            selectedFragment = bookmarkFragment;

        } else if (itemId == R.id.setting) {
            selectedFragment = settingFragment;

        } else if (itemId == R.id.profile) {
            selectedFragment = profileFragment;
        }

        if (selectedFragment != activeFragment) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, selectedFragment)
                    .commit();
            activeFragment = selectedFragment;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
            if (!(activeFragment instanceof JobsFragment)) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, jobsFragment)
                        .commit();
                activeFragment = jobsFragment;

            } else {
                super.onBackPressed();
            }
        }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}
