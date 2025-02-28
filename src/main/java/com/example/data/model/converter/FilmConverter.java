package com.example.data.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.example.data.entity.FilmEntity;
import com.example.data.model.FilmDTO;

public class FilmConverter {
    public FilmEntity convertToEntity(FilmDTO filmDTO) {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setFilm_id(filmDTO.getFilmId());
        filmEntity.setFilm_name(filmDTO.getFilmName());
        filmEntity.setFilm_description(filmDTO.getFilmDescription());
        filmEntity.setPoster_img(filmDTO.getPosterImg());
        filmEntity.setStatus(filmDTO.getStatus());
        filmEntity.setRelease_date(filmDTO.getReleaseDate());
        filmEntity.setVideo(filmDTO.getVideo());
        return filmEntity;
    }

    static public FilmDTO convertFromEntity(FilmEntity filmEntity) {
        return new FilmDTO(filmEntity);
    } 

    static public List<FilmDTO> convertFromEntityList(List<FilmEntity> filmEntities) {
        return filmEntities.stream().map(FilmConverter::convertFromEntity).collect(Collectors.toList());
    }

    public List<FilmEntity> convertToEntityList(List<FilmDTO> filmDTOs) {
        return filmDTOs.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
