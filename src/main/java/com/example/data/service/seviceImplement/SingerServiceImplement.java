package com.example.data.service.seviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.entity.SingerEntity;
import com.example.data.model.SingerDTO;
import com.example.data.model.converter.SingerConverter;
import com.example.data.repository.SingerRepository;
import com.example.data.service.SingerService;

@Service
public class SingerServiceImplement implements SingerService {
    @Autowired
    private SingerRepository singerRepository;

    @Override
    public List<SingerDTO> findBySongId(Integer songId) {
        List<SingerEntity> entities = singerRepository.findBySongId(songId);

        return SingerConverter.toDTOList(entities);
    }
}
