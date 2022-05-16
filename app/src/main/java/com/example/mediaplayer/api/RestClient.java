package com.example.mediaplayer.api;

import static com.example.mediaplayer.util.Constants.SERVER_APP_URL;

import android.os.Build;

import com.example.mediaplayer.util.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.TlsVersion;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private AppClient appClient;
    private static RestClient instance;

    public static RestClient getInstance(){
        if (instance == null){
            synchronized (RestClient.class){
                instance = new RestClient();
            }
        }
        return instance;
    }

    public AppClient getAppClient() {
        return appClient;
    }
    private AppClient createAppClient(){
        return new Retrofit.Builder()
                .baseUrl(Constants.SERVER_APP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build().create(AppClient.class);
    }

    private RestClient(){
        appClient = createAppClient();
    }
}
