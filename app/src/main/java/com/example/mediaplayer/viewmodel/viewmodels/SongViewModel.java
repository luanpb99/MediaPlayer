package com.example.mediaplayer.viewmodel.viewmodels;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LiveData;

import com.example.mediaplayer.model.response.SongResponse;
import com.example.mediaplayer.viewmodel.repository.Repository;

public class SongViewModel extends BaseObservable {
    private Repository songRepository;

    public SongViewModel() {
        this.songRepository = new Repository();
    }
    public LiveData<SongResponse> getSongResponse(String category, Context context){
        return songRepository.getSongResponse(category,context);
    }
}
