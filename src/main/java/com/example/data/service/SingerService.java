package com.example.data.service;

import java.util.List;

import com.example.data.model.SingerDTO;

public interface SingerService {
    public List<SingerDTO> findBySongId(Integer songId);
}
