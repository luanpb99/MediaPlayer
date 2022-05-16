package com.example.mediaplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediaplayer.R;
import com.example.mediaplayer.databinding.ItemSongBinding;
import com.example.mediaplayer.model.entity.Song;
import com.example.mediaplayer.view.PlayerActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHoder> {
    private List<Song> songList = new ArrayList<>();
    private Context context;

    public SongAdapter(Context context) {
        this.context = context;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongAdapter.SongViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSongBinding itemSongBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_song,parent,false);
        return new SongViewHoder(itemSongBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.SongViewHoder holder, int position) {
        Song song = songList.get(position);
        holder.setSongBinding(song);
        holder.itemView.setOnClickListener(view -> {
            clickGoToPlayer(position);
        });
    }

    private void clickGoToPlayer(int position){
        Intent intent = new Intent(context, PlayerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("pos",position);
        bundle.putSerializable("songs", (Serializable) songList);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (songList != null){
            return songList.size();
        }
        return 0;
    }

    public class SongViewHoder extends RecyclerView.ViewHolder {
        ItemSongBinding itemSongBinding;
        public SongViewHoder(ItemSongBinding itemSongBinding) {
            super(itemSongBinding.getRoot());
            this.itemSongBinding = itemSongBinding;
        }
        public void setSongBinding(Song song){
            itemSongBinding.setSong(song);
            itemSongBinding.executePendingBindings();
        }
    }
}
