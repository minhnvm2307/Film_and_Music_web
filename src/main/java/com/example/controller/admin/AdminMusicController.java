package com.example.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.data.model.CategoryDTO;
import com.example.data.model.SingerDTO;
import com.example.data.model.SongDTO;
import com.example.data.model.converter.SongManagerService;
import com.example.data.service.CategoryService;
import com.example.data.service.SingerService;
import com.example.data.service.SongService;
import com.example.data.service.UserService;



@Controller
public class AdminMusicController {
    @Autowired
    private SongService songService;

    @Autowired
    private UserService userService;

    @Autowired
    private SingerService singerService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("admin/music/get-all")
    @ResponseBody
    public List<SongDTO> getMethodName() {
        return songService.getAllSongs();
    }

    @GetMapping("admin/music/get-by-id")
    @ResponseBody
    public Object getSongById(@RequestParam("songId") int songId) {
        return songService.getSongById(songId);
    }

    @GetMapping("admin/music/song-detail")
    @ResponseBody
    public SongDTO getSongDetail(@RequestParam("songId") int songId) {
        List<SongDTO> songs = songService.getAllSongs();
        SongDTO song = null;
        for (SongDTO s : songs) {
            if (s.getSongId() == songId) {
                song = s;
            }
        }
        return song;
    }

    @GetMapping("admin/singer/get-all")
    @ResponseBody
    public List<SingerDTO> getAllSinger() {
        return singerService.getAllSingers();
    }

    @GetMapping("admin/category/get-all")
    @ResponseBody
    public List<CategoryDTO> getAllCategory() {
        return categoryService.findAllSongCategory();
    }

    @PostMapping("admin/music/add")
    @ResponseBody
    public String addSong(@RequestBody Map<String, Object> songData) {
        SongDTO songDTO = SongManagerService.convert(songData, categoryService, singerService);
        songService.addSong(songDTO);
        
        return "success";
    }

    @PostMapping("admin/music/update")
    @ResponseBody
    public String updateSong(@RequestBody Map<String, Object> songData) {
        SongDTO songDTO = SongManagerService.convert(songData, categoryService, singerService);
        songService.updateSong(songDTO);
        
        return "success";
    }

    @PostMapping("admin/music/delete")
    @ResponseBody
    public String deleteSong(@RequestParam("songId") int songId) {
        songService.deleteSong(songId);
        return "success";
    }    

    /*
    * Music Management Page Components
    * - Get all songs
    * - Get all singers
    * - Get all categories
     */    
    @GetMapping("admin/music")
    public String getMusicPage(Model model, @RequestParam("username") String username) {
        model.addAttribute("User", userService.getUserByUsername(username));
        model.addAttribute("Songs", songService.getAllSongs());
        model.addAttribute("Singers", singerService.getAllSingers());
        model.addAttribute("Categories", categoryService.findAllSongCategory());
        return "admin/music-management";
    }


    /*
    * Singer Management
    * - Get all singers
    * - Add singer
    * - Update singer
    * - Delete singer
    */

    @GetMapping("admin/singer")
    public String getSingerPage(Model model, @RequestParam("username") String username) {
        model.addAttribute("User", userService.getUserByUsername(username));
        model.addAttribute("Singers", singerService.getAllSingers());
        return "admin/singer-management";
    }

    @GetMapping("admin/singer/singer-detail")
    @ResponseBody
    public SingerDTO getSingerDetail(@RequestParam("singerId") int singerId) {
        List<SingerDTO> singers = singerService.getAllSingers();
        SingerDTO singer = null;
        for (SingerDTO s : singers) {
            if (s.getSingerId() == singerId) {
                singer = s;
            }
        }
        return singer;
    }

    @PostMapping("admin/singer/add")
    @ResponseBody
    public String addSinger(@RequestBody Map<String, Object> singerData) {
        SingerDTO singerDTO = SongManagerService.convertSinger(singerData);
        singerService.addSinger(singerDTO);
        return "success";
    }

    @PostMapping("admin/singer/update")
    @ResponseBody
    public String updateSinger(@RequestBody Map<String, Object> singerData) {
        SingerDTO singerDTO = SongManagerService.convertSinger(singerData);
        singerService.updateSinger(singerDTO);
        return "success";
    }

    @PostMapping("admin/singer/delete")
    @ResponseBody
    public String deleteSinger(@RequestParam("singerId") int singerId) {
        singerService.deleteSinger(singerId);
        return "success";
    }
}
