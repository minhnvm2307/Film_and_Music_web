package com.example.data.model.converter;

import java.util.List;

import com.example.data.entity.SingerEntity;
import com.example.data.model.SingerDTO;

public class SingerConverter {
    public static SingerDTO toDTO(SingerEntity entity) {
        SingerDTO dto = new SingerDTO();
        dto.setSingerId(entity.getSinger_id());
        dto.setSingerName(entity.getSinger_name());
        dto.setDateOfBirth(entity.getDate_of_birth().toString());
        dto.setCountry(entity.getCountry());
        dto.setDescription(entity.getSinger_description());
        dto.setAvatarImg(entity.getAvatar_img());
        return dto;
    }

    public static SingerEntity toEntity(SingerDTO dto) {
        SingerEntity entity = new SingerEntity();
        entity.setSinger_id(dto.getSingerId());
        entity.setSinger_name(dto.getSingerName());
        entity.setDate_of_birth(java.sql.Date.valueOf(dto.getDateOfBirth()));
        entity.setCountry(dto.getCountry());
        entity.setSinger_description(dto.getDescription());
        entity.setAvatar_img(dto.getAvatarImg());
        return entity;
    }

    public static List<SingerDTO> toDTOList(List<SingerEntity> entities) {
        return entities.stream().map(SingerConverter::toDTO).toList();
    }

    public static List<SingerEntity> toEntityList(List<SingerDTO> dtos) {
        return dtos.stream().map(SingerConverter::toEntity).toList();
    }
}
