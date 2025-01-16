package com.example.data.model.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.data.model.CategoryDTO;
import com.example.data.model.SingerDTO;
import com.example.data.model.SongDTO;
import com.example.data.service.CategoryService;
import com.example.data.service.SingerService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SongManagerService {
    
    public static SongDTO convert(Map<String, Object> songData, CategoryService categoryService, SingerService singerService) {
        SongDTO song = new ObjectMapper().convertValue(songData, SongDTO.class);
        List<CategoryDTO> categories = new ArrayList<>();
        List<SingerDTO> singers = new ArrayList<>();

        for (CategoryDTO category : song.getCategories()) {
            categories.add(categoryService.findById(category.getCategoryId()));
        }
        for (SingerDTO singer : song.getSingers()) {
            singers.add(singerService.findById(singer.getSingerId()));
        }
        song.setCategories(categories);
        song.setSingers(singers);
        
        return song;
    }

    public static SingerDTO convertSinger(Map<String, Object> singerData) {
        return new ObjectMapper().convertValue(singerData, SingerDTO.class);
    }
}
