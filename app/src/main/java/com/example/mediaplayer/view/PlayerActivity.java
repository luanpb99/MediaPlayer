package com.example.mediaplayer.view;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.mediaplayer.R;
import com.example.mediaplayer.base.BaseActivity;
import com.example.mediaplayer.databinding.ActivityPlayerBinding;
import com.example.mediaplayer.model.entity.Song;
import com.example.mediaplayer.viewmodel.viewmodels.PlayerViewModel;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerControlView;

import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends BaseActivity implements Player.Listener{
    PlayerViewModel playerViewModel;
    ActivityPlayerBinding binding;
    List<Song> songList =new ArrayList<>();
    ExoPlayer exoPlayer;
    private int pos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player);
        playerViewModel = new PlayerViewModel(this);
        exoPlayer = playerViewModel.getPlayer();
        getData();
        initPlayer();
        initVolume();
        addListener();
    }

    private void addListener(){
        Player.Listener listener = new Player.Listener() {
            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
                Song song =songList.get(exoPlayer.getCurrentWindowIndex());
                binding.setSong(song);
            }
        };
        exoPlayer.addListener(listener);

    }
    private void getData(){
        Bundle bundle = getIntent().getExtras();
        songList = (List<Song>) bundle.getSerializable("songs");
        pos = bundle.getInt("pos");
    }

    private void initPlayer(){
        binding.exoPlayerView.setPlayer(exoPlayer);
        binding.exoPlayerView.setControllerShowTimeoutMs(0);
        binding.exoPlayerView.setUseArtwork(false);
        binding.exoPlayerView.setControllerHideOnTouch(false);
        playerViewModel.play(songList,pos);
    }

    private void initVolume(){
        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        playerViewModel.setVolume(binding.sbVolume,audioManager);
    }

}
