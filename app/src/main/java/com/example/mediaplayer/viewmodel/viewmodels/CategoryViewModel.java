package com.example.mediaplayer.viewmodel.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;

import com.example.mediaplayer.model.response.CategoryResponse;
import com.example.mediaplayer.viewmodel.repository.Repository;

public class CategoryViewModel extends BaseObservable {
    private Repository categoryRepository;

    public CategoryViewModel() {
        this.categoryRepository = new Repository();
    }

    public MutableLiveData<CategoryResponse> getCategoryResponse(){
        return categoryRepository.getCategoryResponse();
    }
}
