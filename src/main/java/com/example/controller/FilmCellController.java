package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.data.entity.CommentEntity;
import com.example.data.entity.FilmEntity;
import com.example.data.entity.UserEntity;
import com.example.data.model.CommentRequestDTO;
import com.example.data.service.CommentService;
import com.example.data.service.FilmService;
import com.example.data.service.UserService;




@Controller
public class FilmCellController {
    @Autowired
    private FilmService filmService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/film/film-cell")
    // @RequestParam Integer id is the film_id
    public String filmCell(@RequestParam String username, @RequestParam Integer film_id,  Model model) {
        model.addAttribute("FilmCell", filmService.getFilmById(film_id));

        model.addAttribute("FilmsWithRating", filmService.getFilmsWithRatings());

        model.addAttribute("User", userService.getUserByUsername(username));

        model.addAttribute("Comments", commentService.getTopLevelCommentsByFilmId(film_id));
        
        return "film/film-cell";
    }

    @PostMapping("/user/film/film-cell/comment")
    public ResponseEntity<Boolean> addComment(@RequestBody CommentRequestDTO commentDto) {
        // Print the commentDto to the console
        System.out.println("Comment: " + commentDto.getCommentText());
        System.out.println("UserID: " + commentDto.getUserId());
        System.out.println("FilmID: " + commentDto.getFilmId());


        UserEntity user = userService.getUserById(commentDto.getUserId());
        if (user == null) {
            return ResponseEntity.badRequest().body(false);
        }

        FilmEntity film = filmService.getFilmByIdDefault(commentDto.getFilmId());
        if (film == null) {
            return ResponseEntity.badRequest().body(false);
        }

        // Create a new CommentEntity
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setUser(user);
        commentEntity.setFilm(film);
        commentEntity.setComment_text(commentDto.getCommentText());
        commentEntity.setType(commentDto.getType());
        commentEntity.setTime_rated(commentDto.getTimeRated());
        commentEntity.setParentComment(null);

        commentService.saveComment(commentEntity);

        return ResponseEntity.ok(true);
    }


    
}
