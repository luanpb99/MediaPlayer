package com.example.mediaplayer.viewmodel.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.SeekBar;

import androidx.databinding.BaseObservable;

import com.example.mediaplayer.model.entity.AudioPlayer;
import com.example.mediaplayer.model.entity.Song;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import java.util.ArrayList;
import java.util.List;

public class PlayerViewModel extends BaseObservable {
    ExoPlayer player;
    Context context;

    public PlayerViewModel(Context context) {
        this.context = context;
        player = AudioPlayer.getInstance(context).getExoPlayer();
    }

    public ExoPlayer getPlayer() {
        return player;
    }

    public void play(List<Song> songList, int pos){
        player.clearMediaItems();
        player.addMediaItems(buildMediaItems(songList));
        player.seekTo(pos,0);
        player.setRepeatMode(player.REPEAT_MODE_ALL);
        player.prepare();
        player.play();
    }

    public List<MediaItem> buildMediaItems(List<Song> songList){
        List<MediaItem> itemList = new ArrayList<>();
        for (Song song : songList){
            MediaItem item = new MediaItem.Builder()
                    .setUri(song.getUriSong())
                    .build();
            itemList.add(item);
        }
        return itemList;
    }

    public void setVolume(SeekBar seekBar, AudioManager audioManager) {
        seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
