package com.example.data.model.converter;

import com.example.data.entity.SongCategoryEntity;
import com.example.data.model.CategoryDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConveter {
    public static CategoryDTO toDTO(SongCategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(categoryEntity.getCategoryId());
        categoryDTO.setCategoryName(categoryEntity.getCategoryName());
        return categoryDTO;
    }

    public static SongCategoryEntity toEntity(CategoryDTO categoryDTO) {
        SongCategoryEntity categoryEntity = new SongCategoryEntity();
        categoryEntity.setCategoryId(categoryDTO.getCategoryId());
        categoryEntity.setCategoryName(categoryDTO.getCategoryName());
        return categoryEntity;
    }

    public static List<CategoryDTO> toDTOList(List<SongCategoryEntity> categoryEntities) {
        return categoryEntities.stream().map(CategoryConveter::toDTO).collect(Collectors.toList());
    }

    public static List<SongCategoryEntity> toEntityList(List<CategoryDTO> categoryDTOs) {
        return categoryDTOs.stream().map(CategoryConveter::toEntity).collect(Collectors.toList());
    }
}
