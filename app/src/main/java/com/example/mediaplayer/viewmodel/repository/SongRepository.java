package com.example.mediaplayer.viewmodel.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mediaplayer.api.RestClient;
import com.example.mediaplayer.model.response.CategoryResponse;
import com.example.mediaplayer.model.response.SongResponse;
import com.example.mediaplayer.util.Utils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SongRepository {
    MutableLiveData<SongResponse> data = new MutableLiveData<>();

    public LiveData<SongResponse> getCategoryResponse(String category,Context context){
        Observable<SongResponse> oData = RestClient.getInstance().getAppClient().getSongs(Utils.getDeviceCode(context),0,category);
        oData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> data.setValue(o));
        return data;
    }
}
