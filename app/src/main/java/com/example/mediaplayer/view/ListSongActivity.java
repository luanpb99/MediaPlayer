package com.example.mediaplayer.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mediaplayer.R;
import com.example.mediaplayer.adapter.SongAdapter;
import com.example.mediaplayer.base.BaseActivity;
import com.example.mediaplayer.databinding.ActivityListSongBinding;
import com.example.mediaplayer.model.entity.Song;
import com.example.mediaplayer.model.response.SongResponse;
import com.example.mediaplayer.viewmodel.viewmodels.SongViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListSongActivity extends BaseActivity {
    SongAdapter songAdapter;
    SongViewModel songViewModel;
    ActivityListSongBinding binding;
    String codeCategory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_song);
        init();
        codeCategory = getIntent().getStringExtra("codeCategory");
    }
    private void init(){
        songViewModel = new SongViewModel();
        songAdapter = new SongAdapter(this);
        binding.rvListSong.setAdapter(songAdapter);
        binding.rvListSong.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (songViewModel != null){
            songViewModel.getSongResponse(codeCategory,this).observe(
                    this,o ->{
                        if (o instanceof SongResponse){
                            if (songAdapter != null){
                                songAdapter.setSongList(o.getSongList());
                            }

                        }
                    }
            );
        }
    }
}
