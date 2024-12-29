package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.data.entity.FilmEntity;
import com.example.data.entity.StarRatedEntity;
import com.example.data.entity.UserEntity;
import com.example.data.repository.FilmRepository;
import com.example.data.repository.StarRatedRepository;
import com.example.data.service.FilmService;
import com.example.data.service.seviceImplement.FilmImplement;

@ExtendWith(MockitoExtension.class)
public class FilmServiceTest {
    @Mock
    private FilmService filmService;

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private StarRatedRepository starRatedRepository;

    private UserEntity mockUserEntity() {
        UserEntity user = new UserEntity();
        user.setUser_id(1);
        user.setUsername("minhnvm2307");
        user.setName("Nguyen Van Minh");
        return user;
    }

    private FilmEntity mockFilmEntity() {
        FilmEntity film = new FilmEntity();
        film.setFilm_id(1);
        film.setFilm_name("Phim cua Nguyen Van Minh");
        return film;
    }

    private StarRatedEntity mockStarRatedEntity() {
        StarRatedEntity starRated = new StarRatedEntity();
        starRated.setStarRatedId(1);
        starRated.setFilm(mockFilmEntity());
        starRated.setUser_id(mockUserEntity().getUser_id());
        starRated.setStarNumber(5);
        return starRated;
    }

    @Test
    public void testRateFilm() {
        // Mock the repository methods
        // Rate the film id 1 (mockFilmEntity) with rating 5 by user id 1 (Nguyen Van Minh)
        StarRatedEntity mockStarRated = mockStarRatedEntity();
        when(starRatedRepository.findByUserIDAndFilmID(mockUserEntity().getUser_id(), mockFilmEntity().getFilm_id())).thenReturn(mockStarRated);
        
        filmService.rateFilm(mockFilmEntity().getFilm_id(), mockUserEntity().getUser_id(), 4);

        StarRatedEntity starRated = starRatedRepository.findByUserIDAndFilmID(mockUserEntity().getUser_id(), mockFilmEntity().getFilm_id());
        assertNotNull(starRated, "Rating of user id 1 for film id 1 should not be null");
        assertEquals(5, starRated.getStarNumber(), "Rating of user id 1 for film id 1 should be 5");
    }

    @Test
    public void testGetRatingByUser() {
        // Mock the repository methods
        // Rate the film id 1 (mockFilmEntity) with rating 5 by user id 1 (Nguyen Van Minh)
        StarRatedEntity mockStarRated = mockStarRatedEntity();
        when(starRatedRepository.findByUserIDAndFilmID(mockUserEntity().getUser_id(), mockFilmEntity().getFilm_id())).thenReturn(mockStarRated);

        StarRatedEntity starRated = filmService.getRatingByUser(mockFilmEntity().getFilm_id(), mockUserEntity().getUser_id());
        assertNotNull(starRated, "Rating of user id 1 for film id 1 should not be null");
        assertEquals(5, starRated.getStarNumber(), "Rating of user id 1 for film id 1 should be 5");
    }
    
}