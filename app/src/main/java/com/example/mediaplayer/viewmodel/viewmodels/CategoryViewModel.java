package com.example.mediaplayer.viewmodel.viewmodels;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mediaplayer.model.response.CategoryResponse;
import com.example.mediaplayer.viewmodel.repository.CategoryRepository;

public class CategoryViewModel extends BaseObservable {
    private CategoryRepository categoryRepository;

    public CategoryViewModel() {
        this.categoryRepository = new CategoryRepository();
    }

    public MutableLiveData<CategoryResponse> getCategoryResponse(){
        return categoryRepository.getCategoryResponse();
    }
}
