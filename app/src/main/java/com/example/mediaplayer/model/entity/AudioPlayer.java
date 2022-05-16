package com.example.mediaplayer.model.entity;

import android.content.Context;

import com.google.android.exoplayer2.ExoPlayer;

public class AudioPlayer {
    private static AudioPlayer instance;
    private ExoPlayer exoPlayer;

    public static AudioPlayer getInstance(Context context) {
        if ( instance == null){
            synchronized (AudioPlayer.class){
                return instance = new AudioPlayer(context);
            }
        }
        return instance;
    }
    private AudioPlayer(Context context){
        exoPlayer = new ExoPlayer.Builder(context).build();
    }

    public ExoPlayer getExoPlayer() {
        return exoPlayer;
    }
}
