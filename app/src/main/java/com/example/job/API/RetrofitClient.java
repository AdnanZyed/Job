package com.example.job.API;

import android.content.Context;

import com.example.job.LanguageManager;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static LanguageManager languageManager;

    public static void init(Context context) {
        languageManager = new LanguageManager(context);
    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(chain -> {
                Request original = chain.request();
                HttpUrl originalUrl = original.url();
                String urlWithLanguage = languageManager.getUrlWithLanguage("https://fursaty.kicklance.com/ar/api/job-seeker/all-jobs");
                Request.Builder requestBuilder = original.newBuilder()
                        .url(urlWithLanguage);

                return chain.proceed(requestBuilder.build());
            });

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://fursaty.kicklance.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    public static void resetClient() {
        retrofit = null;
    }
}
