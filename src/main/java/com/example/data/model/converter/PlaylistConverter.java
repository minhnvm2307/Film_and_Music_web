package com.example.data.model.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.data.entity.PlaylistEntity;
import com.example.data.model.PlaylistDTO;

public class PlaylistConverter {
    public static PlaylistEntity toEntity(PlaylistDTO playlistDTO) {
        PlaylistEntity playlistEntity = new PlaylistEntity();
        playlistEntity.setPlaylist_id(playlistDTO.getPlaylistId());
        playlistEntity.setPlaylist_name(playlistDTO.getPlaylistName());
        playlistEntity.setUser_id(playlistDTO.getUserId());

        return playlistEntity;
    }
    
    public static PlaylistDTO toDTO(PlaylistEntity playlistEntity) {
        PlaylistDTO playlistDTO = new PlaylistDTO();
        playlistDTO.setPlaylistId(playlistEntity.getPlaylist_id());
        playlistDTO.setPlaylistName(playlistEntity.getPlaylist_name());
        playlistDTO.setUserId(playlistEntity.getUser_id());

        return playlistDTO;
    }

    public static List<PlaylistDTO> toDTOList(List<PlaylistEntity> playlistEntities) {
        List<PlaylistDTO> playlistDTOs = new ArrayList<>();
        for (PlaylistEntity playlistEntity : playlistEntities) {
            playlistDTOs.add(toDTO(playlistEntity));
        }
        return playlistDTOs;
    }

    public static List<PlaylistEntity> toEntityList(List<PlaylistDTO> playlistDTOs) {
        List<PlaylistEntity> playlistEntities = new ArrayList<>();
        for (PlaylistDTO playlistDTO : playlistDTOs) {
            playlistEntities.add(toEntity(playlistDTO));
        }
        return playlistEntities;
    }
}
