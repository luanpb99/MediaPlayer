package com.example.mediaplayer.api;

import com.example.mediaplayer.model.entity.Category;
import com.example.mediaplayer.model.entity.Song;
import com.example.mediaplayer.model.response.CategoryResponse;
import com.example.mediaplayer.model.response.SongResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AppClient {
    @GET("categories")
    Observable<CategoryResponse> getCategories();

    @GET("songs")
    Observable<SongResponse> getSongs(@Query("deviceCode") String deviceCode,
                                      @Query("page") Integer page,
                                      @Query("category") String category);
}
