package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.data.model.SongDTO;
import com.example.data.service.SongService;
import com.example.data.service.UserService;

@Controller
public class MusicController {

    @Autowired
    private SongService songService;

    @Autowired
    private UserService userService;

    @GetMapping("/music/music-page")
    public String musicPage(@RequestParam String username, Model model) {
        model.addAttribute("Songs", songService.getAllSongs());

        model.addAttribute("User", userService.getUserByUsername(username));
        
        return "music/music-page";
    }

    @GetMapping("/music/song-detail")
    @ResponseBody
    public List<SongDTO> songDetail() {
        return songService.getAllSongs();
    }

    @GetMapping("/music/song")
    @ResponseBody
    public Object songDetail(@RequestParam Integer songId) {
        return songService.getSongById(songId);
    }
    
}
