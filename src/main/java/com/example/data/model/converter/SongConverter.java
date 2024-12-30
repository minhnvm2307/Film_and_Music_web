package com.example.data.model.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.data.entity.SongEntity;
import com.example.data.model.SongDTO;

public class SongConverter {
    // Single converter methods
    public static SongDTO convertToDTO(SongEntity songEntity) {
        SongDTO newSongDTO = new SongDTO();
        newSongDTO.setSongId(songEntity.getSong_id());
        newSongDTO.setSongName(songEntity.getSong_name());
        newSongDTO.setSongDescription(songEntity.getSong_description());
        newSongDTO.setReleaseDate(songEntity.getRelease_date().toString());
        newSongDTO.setPosterImg(songEntity.getPoster_img());
        newSongDTO.setAudioLink(songEntity.getAudio_link());
        newSongDTO.setSingers(SingerConverter.toDTOList(songEntity.getSingers()));
        newSongDTO.setCategories(CategoryConveter.toDTOList(songEntity.getCategories()));
        return newSongDTO;
    }

    public static SongEntity convertToEntity(SongDTO songDTO) {
        SongEntity newSongEntity = new SongEntity();
        newSongEntity.setSong_id(songDTO.getSongId());
        newSongEntity.setSong_name(songDTO.getSongName());
        newSongEntity.setSong_description(songDTO.getSongDescription());
        newSongEntity.setRelease_date(java.sql.Date.valueOf(songDTO.getReleaseDate()));
        newSongEntity.setPoster_img(songDTO.getPosterImg());
        newSongEntity.setAudio_link(songDTO.getAudioLink());
        newSongEntity.setSingers(SingerConverter.toEntityList(songDTO.getSingers()));
        return newSongEntity;
    }

    // List converter methods
    public static List<SongDTO> convertToDTOList(List<SongEntity> songEntityList) {
        List<SongDTO> newSongDTOList = new ArrayList<>();
        for (SongEntity songEntity : songEntityList) {
            newSongDTOList.add(convertToDTO(songEntity));
        }
        return newSongDTOList;
    }

    public static List<SongEntity> convertToEntityList(List<SongDTO> songDTOList) {
        List<SongEntity> newSongEntityList = new ArrayList<>();
        for (SongDTO songDTO : songDTOList) {
            newSongEntityList.add(convertToEntity(songDTO));
        }
        return newSongEntityList;
    }
    
}
