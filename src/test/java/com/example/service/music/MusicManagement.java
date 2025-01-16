package com.example.service.music;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.data.model.SingerDTO;
import com.example.data.model.SongDTO;
import com.example.data.service.CategoryService;
import com.example.data.service.SingerService;
import com.example.data.service.SongService;
import com.example.data.service.UserService;

@ExtendWith(MockitoExtension.class)
public class MusicManagement {

    @Mock
    private SongService songService;

    @Mock
    private SingerService singerService;

    @Mock 
    private UserService userService;

    @Mock
    private CategoryService categoryService;

    private SongDTO getInitSong() {
        // Add some songs
        SongDTO newSong = new SongDTO(9999, "New Song Name", "No description", "23/07/2005", "https://www.youtube.com/watch?v=123456", "https://www.google.com/image/123456", null, null);

        return newSong;
    }
    
    SingerDTO getInitSinger() {
        // Add some singers
        SingerDTO newSinger = new SingerDTO(9999, "New Singer Name", "23/07/2005", "VietNam", "No description", "https://www.google.com/image/123456");

        return newSinger;
    }

    @Test
    public void testCheckExistSong() {
        // Check if song exists
        Object songDTO = songService.getSongById(9999);

        assertNull(songDTO, "Song with ID 9999 should not exist initially");
    }
    
    @Test
    public void testAddNewSong() {
        SongDTO newSong = getInitSong();
        // Add new song
        songService.addSong(newSong);

        // Check if new song exists
        Object songDTO = songService.getSongById(newSong.getSongId());
        assertNotNull(songDTO, "Song with ID 9999 should exist after adding");
    }
}
