package com.example.job;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class NotRegisteredBottomSheet extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_not_registered, container, false);

        view.findViewById(R.id.btnLogin).setOnClickListener(v -> {
            // فتح شاشة تسجيل الدخول

        });

        view.findViewById(R.id.btnSignup).setOnClickListener(v -> {
            //  فتح شاشة التسجيل
           // startActivity(new Intent(getContext(), SignupActivity.class));
        });

        return view;
    }
}
