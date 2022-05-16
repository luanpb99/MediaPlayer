package com.example.mediaplayer.viewmodel.viewmodels;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LiveData;

import com.example.mediaplayer.model.response.SongResponse;
import com.example.mediaplayer.viewmodel.repository.SongRepository;

public class SongViewModel extends BaseObservable {
    private SongRepository songRepository;

    public SongViewModel() {
        this.songRepository = new SongRepository();
    }
    public LiveData<SongResponse> getSongResponse(String category, Context context){
        return songRepository.getCategoryResponse(category,context);
    }
}
