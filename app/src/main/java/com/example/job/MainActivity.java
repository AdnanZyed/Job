package com.example.job;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

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

        ImageView notificationBTN = findViewById(R.id.notification_ic_btn);
        ImageView filterIc = findViewById(R.id.filter_ic);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Open Jobs Fragment by default
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, jobsFragment)
                .commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.jobs);

        // Filter Button
        filterIc.setOnClickListener(v -> {

            Toast.makeText(
                    MainActivity.this,
                    "Loading filters...",
                    Toast.LENGTH_SHORT
            ).show();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://fursaty.kicklance.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiService api = retrofit.create(ApiService.class);

            Call<FilterResponse> call = api.getFilters();

            call.enqueue(new Callback<FilterResponse>() {

                @Override
                public void onResponse(Call<FilterResponse> call,
                                       Response<FilterResponse> response) {

                    if (response.isSuccessful()
                            && response.body() != null
                            && response.body().isStatus()) {

                        showFilterBottomSheet(
                                response.body().getData()
                        );

                    } else {

                        Toast.makeText(
                                getApplicationContext(),
                                "Failed to load filters",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }

                @Override
                public void onFailure(Call<FilterResponse> call, Throwable t) {

                    Toast.makeText(
                            getApplicationContext(),
                            "Error: " + t.getMessage(),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            });
        });

        // Search Button
        findViewById(R.id.search_ic).setOnClickListener(v -> {

            if (jobsFragment != null
                    && jobsFragment.getCurrentJobs() != null) {

                JobSearchBottomSheet bottomSheet =
                        new JobSearchBottomSheet(
                                jobsFragment.getCurrentJobs()
                        );

                bottomSheet.show(
                        getSupportFragmentManager(),
                        bottomSheet.getTag()
                );
            }
        });

        // Notification Button
        notificationBTN.setOnClickListener(v -> {

            View bottomSheetView = LayoutInflater.from(MainActivity.this)
                    .inflate(
                            R.layout.notification_settings_sheet,
                            null
                    );

            BottomSheetDialog bottomSheetDialog =
                    new BottomSheetDialog(MainActivity.this);

            bottomSheetDialog.setContentView(bottomSheetView);

            bottomSheetDialog.show();
        });
    }

    // Show Fragment With Animation
    private void showFragment(Fragment fragment, String title) {

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                )
                .replace(R.id.flFragment, fragment)
                .commit();

        setTitle(title);
    }

    // Show Filter Bottom Sheet
    private void showFilterBottomSheet(List<FilterItem> filterItems) {

        View view = LayoutInflater.from(this)
                .inflate(R.layout.bottom_sheet_filter, null);

        RecyclerView recyclerView =
                view.findViewById(R.id.filterRecyclerView);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        FilterAdapter adapter = new FilterAdapter(
                filterItems,
                item -> Toast.makeText(
                        this,
                        "Selected: " + item.getName(),
                        Toast.LENGTH_SHORT
                ).show()
        );

        recyclerView.setAdapter(adapter);

        BottomSheetDialog dialog =
                new BottomSheetDialog(this);

        dialog.setContentView(view);

        dialog.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(
            @NonNull MenuItem item
    ) {

        Fragment selectedFragment = null;

        int itemId = item.getItemId();

        String title = "";

        if (itemId == R.id.jobs) {

            selectedFragment = jobsFragment;
            title = "Jobs";

        } else if (itemId == R.id.bookmark) {

            selectedFragment = bookmarkFragment;
            title = "Bookmarks";

        } else if (itemId == R.id.setting) {

            selectedFragment = settingFragment;
            title = "Settings";

        } else if (itemId == R.id.profile) {

            selectedFragment = profileFragment;
            title = "Profile";
        }

        if (selectedFragment != activeFragment) {

            showFragment(selectedFragment, title);

            Toast.makeText(
                    this,
                    title + " Selected",
                    Toast.LENGTH_SHORT
            ).show();

            activeFragment = selectedFragment;
        }

        return true;
    }

    @Override
    public void onBackPressed() {

        if (!(activeFragment instanceof JobsFragment)) {

            showFragment(jobsFragment, "Jobs");

            bottomNavigationView.setSelectedItemId(R.id.jobs);

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