package com.example.data.service.seviceImplement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.entity.SingerEntity;
import com.example.data.entity.SongCategoryEntity;
import com.example.data.entity.SongEntity;
import com.example.data.model.CategoryDTO;
import com.example.data.model.SongDTO;
import com.example.data.model.converter.SongConverter;
import com.example.data.repository.SingerRepository;
import com.example.data.repository.SongCategoryRepository;
import com.example.data.repository.SongRepository;
import com.example.data.service.SongService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class SongServiceImplement implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SongCategoryRepository songCategoryRepository;

    @Autowired
    private SingerRepository singerRepository;

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
    public SongEntity findByIdDefault(Integer songId) {
        return songRepository.findById(songId).get();
    }

    @Override
    public List<SongDTO> getSongByCategoryName(String categoryName) {
        List<SongEntity> songEntities = songRepository.findSongByCategoryName(categoryName);
        return SongConverter.convertToDTOList(songEntities);
    }
    
    @Override
    public CategoryDTO getCategoryById(Integer categoryId) {
        SongCategoryEntity songCategoryEntity = songCategoryRepository.findById(categoryId).get();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(songCategoryEntity.getCategoryId());
        categoryDTO.setCategoryName(songCategoryEntity.getCategoryName());
        categoryDTO.setCategoryDescription(songCategoryEntity.getDescription());

        return categoryDTO;
    }

    @Override
    @Transactional
    public void addSong(SongDTO songDTO) {
        // Convert DTO to Entity
        SongEntity songEntity = SongConverter.convertToEntity(songDTO);

        songEntity.setSingers(null);
        songEntity.setCategories(null);

        SongEntity savedSong = songRepository.save(songEntity);

        addConstraintOfSong(savedSong, songDTO);

        // Save the song entity again with updated relationships
        songRepository.save(savedSong);
    }

    @Override
    @Transactional
    public void updateSong(SongDTO songDTO) {
        // Convert DTO to Entity
        SongEntity songEntity = SongConverter.convertToEntity(songDTO);
        addConstraintOfSong(songEntity, songDTO);
        
        songRepository.save(songEntity);
    }

    @Override
    public void deleteSong(int songId) {
        songRepository.deleteById(songId);
    }

    // Support method
    private void addConstraintOfSong(SongEntity savedSong, SongDTO songDTO) {
        // Ensure singers and categories are managed entities
        List<SingerEntity> singerEntities = songDTO.getSingers().stream()
            .map(singer -> singerRepository.findById(singer.getSingerId())
                .orElseThrow(() -> new EntityNotFoundException("Singer not found with ID: " + singer.getSingerId())))
            .collect(Collectors.toList());

        List<SongCategoryEntity> categoryEntities = songDTO.getCategories().stream()
            .map(category -> songCategoryRepository.findById(category.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID: " + category.getCategoryId())))
            .collect(Collectors.toList());

        // Update the song with singers and categories
        savedSong.setSingers(singerEntities);
        savedSong.setCategories(categoryEntities);
    }
}
