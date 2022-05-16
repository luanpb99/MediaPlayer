package com.example.mediaplayer.viewmodel.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.mediaplayer.api.RestClient;
import com.example.mediaplayer.model.response.CategoryResponse;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CategoryRepository {
    MutableLiveData<CategoryResponse> data = new MutableLiveData<>();

    public MutableLiveData<CategoryResponse> getCategoryResponse(){
        Observable<CategoryResponse> oData = RestClient.getInstance().getAppClient().getCategories();
        oData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> data.setValue(o));
        return data;
    }
}
