package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.data.entity.CommentEntity;
import com.example.data.entity.SongEntity;
import com.example.data.entity.UserEntity;
import com.example.data.model.CategoryDTO;
import com.example.data.model.CommentRequestDTO;
import com.example.data.model.SongDTO;
import com.example.data.service.CommentService;
import com.example.data.service.PlaylistService;
import com.example.data.service.SongService;
import com.example.data.service.UserService;
import com.example.storage.MusicStorage;

@Controller
public class MusicController {
    private SongService songService;
    private UserService userService;
    private CommentService commentService;
    private PlaylistService playlistService;
    private MusicStorage musicStorage;
    
    MusicController(SongService songService, UserService userService, CommentService commentService, PlaylistService playlistService, MusicStorage musicStorage) {
        this.songService = songService;
        this.userService = userService;
        this.commentService = commentService;
        this.playlistService = playlistService;
        this.musicStorage = musicStorage;
    }

    /*
    * The main page for MUSIC section
    * Including Song list
    * Playing card in background
    */
    @GetMapping("/music/music-page")
    public String musicPage(@RequestParam String username, Model model) {
        model.addAttribute("Songs", songService.getAllSongs());

        model.addAttribute("User", userService.getUserByUsername(username));
        
        return "music/music-page";
    }

    /*
    The page for single playing song with more detailed information
    Including all information of one song
    And the list of top trending musics
     */
    @GetMapping("/music/music-cell")
    public String musicDetail(@RequestParam Integer songId, @RequestParam String username, Model model) {
        model.addAttribute("Songs", songService.getAllSongs());

        model.addAttribute("User", userService.getUserByUsername(username));

        List<CommentEntity> topLevelComments = commentService.getTopLevelCommentsBySongId(songId);
        model.addAttribute("Comments", topLevelComments);

        Map<Integer, List<CommentEntity>> childCommentsMap = new HashMap<>();
        for (CommentEntity topLevelComment : topLevelComments) {
            List<CommentEntity> childComments = commentService.getCommentsByParentCommentId(topLevelComment.getComment_id());
            childCommentsMap.put(topLevelComment.getComment_id(), childComments);
        }
        model.addAttribute("ChildCommentsMap", childCommentsMap);

        List<SongDTO> songWithCategory = songService.getAllSongs();
        SongDTO song = songWithCategory.stream().filter(s -> s.getSongId() == songId).findFirst().orElse(null);
        model.addAttribute("Song", song);

        return "music/music-cell";
    }
    

    @GetMapping("/music/song-detail")
    @ResponseBody
    public List<SongDTO> songDetail() {
        return songService.getAllSongs();
    }

    @GetMapping("/music/category")
    @ResponseBody
    public List<SongDTO> songDetail(@RequestParam Integer categoryId) {
        List<SongDTO> songs = songService.getAllSongs();
        CategoryDTO songCategory = songService.getCategoryById(categoryId);
        List<SongDTO> res = new ArrayList<>();

        for (SongDTO song : songs) {
            if (song.getCategories().contains(songCategory)) {
                res.add(song);
            }
        }

        return res;
    }

    @GetMapping("/music/category-song")
    @ResponseBody
    public List<SongDTO> songDetail(@RequestParam String categoryName) {
        return songService.getSongByCategoryName(categoryName);
    }

    @PostMapping("/user/music/music-cell/comment")
    public ResponseEntity<Boolean> addComment(@RequestBody CommentRequestDTO commentDto) {
        // Print the commentDto to the console
        System.out.println("Comment: " + commentDto.getCommentText());
        System.out.println("UserID: " + commentDto.getUserId());
        System.out.println("SongID: " + commentDto.getSongId());


        UserEntity user = userService.getUserById(commentDto.getUserId());
        if (user == null) {
            return ResponseEntity.badRequest().body(false);
        }

        SongEntity song = songService.findByIdDefault(commentDto.getSongId());
        if (song == null) {
            return ResponseEntity.badRequest().body(false);
        }

        CommentEntity parentComment = commentService.getCommentById(commentDto.getParentCommentId());
        if (parentComment != null) {
            System.err.println("Can not find parent comment!!");
        }

        // Create a new CommentEntity
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setUser(user);
        commentEntity.setSong(song);
        commentEntity.setComment_text(commentDto.getCommentText());
        commentEntity.setType(commentDto.getType());
        commentEntity.setTime_rated(commentDto.getTimeRated());
        commentEntity.setParentComment(commentService.getCommentById(commentDto.getParentCommentId()));

        commentService.saveComment(commentEntity);

        return ResponseEntity.ok(true);
    }

    @GetMapping("/user/music/next-play-song")
    @ResponseBody
    public SongDTO saveStatePlayingSong(@RequestParam Integer songId) {
        SongDTO nexSong = musicStorage.getNextSong(songId);
        musicStorage.addToPlaylist(songId);

        return nexSong;
    }

    @GetMapping("/user/music/previous-play-song")
    @ResponseBody
    public SongDTO getPreviousSong() {
        SongDTO previousSong = musicStorage.getPreviousSong();

        return previousSong;
    }


    /*
    * The page for user's music collection
    * Including all playlists and songs
    * User can add, delete, edit playlists and songs
    */
    @GetMapping("/music/collection")
    public String getCollections(@RequestParam String username, Model model) {
        UserEntity user = userService.getUserByUsername(username);

        model.addAttribute("Playlists", playlistService.getAllPlaylist());
        
        model.addAttribute("Songs", songService.getAllSongs());

        model.addAttribute("User", userService.getUserByUsername(username));
        
        return "music/collection-page";
    }

    @GetMapping("/music/collection/song-list")
    public String getSongListFromPlaylist(@RequestParam String username, @RequestParam Integer playlistId, Model model) {
        model.addAttribute("Songs", playlistService.getSongsByPlaylistId(playlistId));

        model.addAttribute("User", userService.getUserByUsername(username));
        
        return "music/collection-page";
    }

    @GetMapping("/music/collection/get-4-poster")
    @ResponseBody
    public List<String> get4Poster(@RequestParam Integer playlistId) {
        List<String> posterUrls = new ArrayList<>();
        // Get 4 poster urls from list of songs in playlist
        List<SongDTO> songs = playlistService.getSongsByPlaylistId(playlistId);
        posterUrls.add(Integer.toString(songs.size()));
        for (int i = 0; i < 4 && i < songs.size(); i++) {
            posterUrls.add(songs.get(i).getPosterImg());
        }

        return posterUrls;
    }

    @PostMapping("/music/collection/add-song-to-playlist")
    @ResponseBody
    public String addSongToPlaylist(@RequestParam Integer songId, @RequestParam Integer playlistId) {
        playlistService.addSongToPlaylist(songId, playlistId);
        return "success";
    }

    // @PostMapping("/music/collection/update-playlist")
    // @ResponseBody
    // public String updatePlaylist(@RequestParam Integer playlistId, @RequestParam String playlistName) {
    //     playlistService.
    //     return "success";
    // }

    @PostMapping("/music/collection/remove-playlist")
    @ResponseBody
    public String removePlaylist(@RequestParam Integer playlistId) {
        playlistService.deletePlaylist(playlistId);
        return "success";
    }
    
}
