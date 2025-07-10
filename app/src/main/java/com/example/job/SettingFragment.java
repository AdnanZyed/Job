package com.example.job;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class SettingFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        LinearLayout linearLayout= view.findViewById(R.id.helpand_feedback);
        LinearLayout ll_language= view.findViewById(R.id.ll_language);
        LinearLayout faqs= view.findViewById(R.id.faqs);
        LinearLayout privacy_policy_btn= view.findViewById(R.id.privacy_policy_btn);
        ll_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLanguageSelector(requireContext());
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), HelpFeedback.class);
                startActivity(intent);
            }
        });
        privacy_policy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetchPrivacyData();

            }
        });
        faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), FAQS.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private void fetchPrivacyData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://your-base-url.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<PrivacyResponse> call = api.getPrivacyData();

        call.enqueue(new Callback<PrivacyResponse>() {
            @Override
            public void onResponse(Call<PrivacyResponse> call, Response<PrivacyResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {
                    PrivacyData data = response.body().getData();
                    showBottomSheet(data.getTitle(), data.getDescription());
                } else {
                    Toast.makeText(requireContext(), "فشل في جلب البيانات", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PrivacyResponse> call, Throwable t) {
                Toast.makeText(requireContext(), "خطأ: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showBottomSheet(String title, String description) {
        View bottomSheetView = LayoutInflater.from(requireContext())
                .inflate(R.layout.privacy_policy, null);

        TextView titleTextView = bottomSheetView.findViewById(R.id.privacy_policy);
        TextView descTextView = bottomSheetView.findViewById(R.id.text_privacy_policy);

        titleTextView.setText(title);
        descTextView.setText(description);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    public void showLanguageSelector(Context context) {
        BottomSheetDialog dialog = new BottomSheetDialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.language_prefrence_sheet, null);
        dialog.setContentView(view);

        LanguageManager langManager = new LanguageManager(context);

        Button btnEnglish = view.findViewById(R.id.btnEnglish);
        Button btnArabic = view.findViewById(R.id.btnArabic);

        btnEnglish.setOnClickListener(v -> {
            langManager.setLanguage("en");
            refreshApp(context);
            dialog.dismiss();
        });

        btnArabic.setOnClickListener(v -> {
            langManager.setLanguage("ar");
            refreshApp(context);
            dialog.dismiss();
        });

        dialog.show();
    }

    private void refreshApp(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}