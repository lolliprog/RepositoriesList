package com.example.inquallity.repositorieslist;

import android.app.Application;

import com.example.inquallity.repositorieslist.api.GitApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Inquallity on 24-Nov-17.
 */

public class AppDelegate extends Application {

    private static GitApi mGitApi;
    private Retrofit mRetrofit;
    private static final String API_URL = "https://api.github.com/";
    private HttpLoggingInterceptor LOGGING = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC);

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(new OkHttpClient.Builder().addInterceptor(LOGGING).build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mGitApi = mRetrofit.create(GitApi.class);
    }

    public static GitApi getmGitApi() {
        return mGitApi;
    }
}
