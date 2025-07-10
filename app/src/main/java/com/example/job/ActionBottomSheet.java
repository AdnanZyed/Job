package com.example.job;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ActionBottomSheet extends BottomSheetDialogFragment {

    private String phoneNumber;

    public static ActionBottomSheet newInstance(String phoneNumber) {
        ActionBottomSheet fragment = new ActionBottomSheet();
        Bundle args = new Bundle();
        args.putString("Phone", phoneNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (getArguments() != null) {
            phoneNumber = getArguments().getString("Phone");
        }

        View view = inflater.inflate(R.layout.bottom_sheet_actions, container, false);

        view.findViewById(R.id.optionCall).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        });

        view.findViewById(R.id.optionSMS).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNumber));
            startActivity(intent);
        });

        view.findViewById(R.id.optionWhatsApp).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/" + phoneNumber));
            startActivity(intent);
        });

        return view;
    }
}
