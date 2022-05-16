package com.example.mediaplayer.model.response;

import com.example.mediaplayer.api.BaseResponse;
import com.example.mediaplayer.model.entity.Song;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SongResponse extends BaseResponse {
    @SerializedName("data")
    private List<Song> songList;

    public List<Song> getSongList() {
        return songList;
    }

}
