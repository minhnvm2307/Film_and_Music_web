package com.example.data.service;

import java.util.List;

import com.example.data.model.ActorDTO;

public interface ActorService {
    public List<ActorDTO> findByFilmId(int filmId);
    
}
