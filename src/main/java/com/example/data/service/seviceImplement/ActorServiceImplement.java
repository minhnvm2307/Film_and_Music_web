package com.example.data.service.seviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.model.ActorDTO;
import com.example.data.model.converter.ActorConverter;
import com.example.data.repository.ActorRepository;
import com.example.data.service.ActorService;
import com.example.data.entity.ActorEntity;

@Service
public class ActorServiceImplement implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<ActorDTO> findByFilmId(int filmId) {
        List<ActorEntity> actorEntities = actorRepository.findByFilmId(filmId);
        
        return ActorConverter.toDTOList(actorEntities);
    }
    
}
