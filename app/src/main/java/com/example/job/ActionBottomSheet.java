package com.example.job;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ActionBottomSheet extends BottomSheetDialogFragment {

    private String phoneNumber = "0590000000"; // رقم افتراضي – عدله حسب الحاجة

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
