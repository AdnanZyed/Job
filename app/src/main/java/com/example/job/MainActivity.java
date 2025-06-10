package com.example.job;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFragment, jobsFragment)
                .commit();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.jobs);


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
