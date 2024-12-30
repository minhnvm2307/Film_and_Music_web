package com.example.data.service.seviceImplement;

import com.example.data.entity.SongEntity;
import com.example.data.model.SongDTO;
import com.example.data.model.converter.SongConverter;
import com.example.data.repository.SongRepository;
import com.example.data.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImplement implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<SongDTO> getAllSongs() {
        List<SongEntity> songEntities = songRepository.findAll();
        return SongConverter.convertToDTOList(songEntities);
    }

    @Override
    public Object getSongById(int songId) {
        return songRepository.findBySongId(songId);
    }

    @Override
    public List<SongDTO> getSongByCategoryName(String categoryName) {
        List<SongEntity> songEntities = songRepository.findSongByCategoryName(categoryName);
        return SongConverter.convertToDTOList(songEntities);
    }
    
}
