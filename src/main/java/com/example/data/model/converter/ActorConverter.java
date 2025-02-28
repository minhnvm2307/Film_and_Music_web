package com.example.data.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.example.data.entity.ActorEntity;
import com.example.data.model.ActorDTO;

public class ActorConverter {
    //Single converter
    public static ActorDTO toDTO(ActorEntity actorEntity) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setActorId(actorEntity.getActor_id());
        actorDTO.setActorName(actorEntity.getActor_name());
        actorDTO.setActorBirthDate(actorEntity.getDate_of_birth());
        actorDTO.setActorDescription(actorEntity.getActor_description());
        actorDTO.setActorImg(actorEntity.getAvatar_img());
    
        return actorDTO;
    }

    public static ActorEntity toEntity(ActorDTO actorDTO) {
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setActor_id(actorDTO.getActorId());
        actorEntity.setActor_name(actorDTO.getActorName());
        actorEntity.setDate_of_birth(actorDTO.getActorBirthDate());
        actorEntity.setActor_description(actorDTO.getActorDescription());
        actorEntity.setAvatar_img(actorDTO.getActorImg());

        return actorEntity;
    }

    // List converter
    public static List<ActorDTO> toDTOList(List<ActorEntity> actorEntities) {
        return actorEntities.stream().map(ActorConverter::toDTO).collect(Collectors.toList());
    }

    public static List<ActorEntity> toEntityList(List<ActorDTO> actorDTOs) {
        return actorDTOs.stream().map(ActorConverter::toEntity).collect(Collectors.toList());
    }
}
