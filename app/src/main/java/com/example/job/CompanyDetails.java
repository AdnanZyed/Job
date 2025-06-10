package com.example.job;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CompanyDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);

//        btnShowDialog.setOnClickListener(v -> {
//            ActionBottomSheet bottomSheet = new ActionBottomSheet();
//            bottomSheet.setPhoneNumber("0590000000"); // غيّر الرقم حسب الحالة
//            bottomSheet.show(getParentFragmentManager(), "ActionBottomSheet");
//        });
        // findViewById(R.id.btnShowBio).setOnClickListener(v -> showBioBottomSheet());

   // findViewById(R.id.imgShare1).setOnClickListener(v -> showBottomSheet());

        new NotRegisteredBottomSheet().show(getSupportFragmentManager(), "NotRegisteredBottomSheet");

    }

    private void showBioBottomSheet() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_bio_bottom_sheet, null);
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        dialog.show();
    }
    private void showBottomSheet() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet, null);
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        dialog.show();

        // إضافة الأكشن على الأيقونات مثلاً:
        ImageView gmail = view.findViewById(R.id.gmail_icon); // بعد ما تضيف ID
        // gmail.setOnClickListener(...);
    }
}