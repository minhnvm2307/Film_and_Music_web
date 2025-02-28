package com.example.data.service;

import java.util.List;

import com.example.data.model.SingerDTO;

public interface SingerService {
    public List<SingerDTO> findBySongId(Integer songId);

    public List<SingerDTO> getAllSingers();

    public SingerDTO findById(Integer singerId);

    public SingerDTO addSinger(SingerDTO singerDTO);

    public SingerDTO updateSinger(SingerDTO singerDTO);

    public void deleteSinger(Integer singerId);
}
