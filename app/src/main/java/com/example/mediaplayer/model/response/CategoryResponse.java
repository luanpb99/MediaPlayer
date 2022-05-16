package com.example.mediaplayer.model.response;

import com.example.mediaplayer.api.BaseResponse;
import com.example.mediaplayer.model.entity.Category;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse extends BaseResponse {
    @SerializedName("data")
    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

}
