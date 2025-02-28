package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.data.entity.CommentEntity;
import com.example.data.entity.FilmEntity;
import com.example.data.entity.StarRatedEntity;
import com.example.data.entity.UserEntity;
import com.example.data.model.CommentRequestDTO;
import com.example.data.service.ActorService;
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

    @Autowired
    private ActorService actorService;

    /*
     * This method is used to display the film-cell page. 
     * When user clicks on a film, this method is called and shows the film (Video).
     * It takes in the username and film_id as parameters.
     * It returns the film-cell.html page.
     * 
     * This page contains atrributes:
     * - FilmCell
     * - FilmsWithRating
     * - User
     * - Actors
     * - Comments (the top level comments - comments with no parent comment)
     * - ChildCommentsMap (map the parent comment ID to its child comments)
     * 
     * @Param username: The username of the user.
     * @Param film_id: The id of the film.
     * 
     * @Return: The film-cell.html page.
     */
    @GetMapping("/film/film-cell")
    // @RequestParam Integer id is the film_id
    public String filmCell(@RequestParam String username, @RequestParam Integer film_id,  Model model) {
        model.addAttribute("FilmCell", filmService.getFilmById(film_id));

        model.addAttribute("FilmsWithRating", filmService.getFilmsWithRatings());

        model.addAttribute("User", userService.getUserByUsername(username));

        model.addAttribute("Actors", actorService.findByFilmId(film_id));

        List<CommentEntity> topLevelComments = commentService.getTopLevelCommentsByFilmId(film_id);
        model.addAttribute("Comments", topLevelComments);

        Map<Integer, List<CommentEntity>> childCommentsMap = new HashMap<>();
        for (CommentEntity topLevelComment : topLevelComments) {
            List<CommentEntity> childComments = commentService.getCommentsByParentCommentId(topLevelComment.getComment_id());
            childCommentsMap.put(topLevelComment.getComment_id(), childComments);
        }
        model.addAttribute("ChildCommentsMap", childCommentsMap);
        
        return "film/film-cell";
    }

    /*
     * This method is used to add a comment to a film.
     * It takes in the commentDto as a parameter.
     * It returns a ResponseEntity with a boolean value.
     * The schema where the API called is in (comment.js) file.
     * 
     * @Param commentDto: The CommentRequestDTO object.
     * 
     * @Return: ResponseEntity with a boolean value.
     */
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

        CommentEntity parentComment = commentService.getCommentById(commentDto.getParentCommentId());
        if (parentComment != null) {
            System.err.println("Can not find parent comment!!");
        }

        // Create a new CommentEntity
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setUser(user);
        commentEntity.setFilm(film);
        commentEntity.setComment_text(commentDto.getCommentText());
        commentEntity.setType(commentDto.getType());
        commentEntity.setTime_rated(commentDto.getTimeRated());
        commentEntity.setParentComment(commentService.getCommentById(commentDto.getParentCommentId()));

        commentService.saveComment(commentEntity);

        return ResponseEntity.ok(true);
    }

    /*
     * This method is used to rate a film.
     * 
     * @Param filmId: The id of the film.
     * @Param userId: The id of the user.
     * @Param rateNumber: The rating number.
     */
    @PostMapping("user/film/film-cell/rating")
    public ResponseEntity<Boolean> ratingFilmCell (@RequestParam Integer filmId, @RequestParam Integer userId, @RequestParam Integer rateNumber) {
        StarRatedEntity newStarRated = filmService.rateFilm(filmId, userId, rateNumber);
        if (newStarRated == null || newStarRated.getStarNumber() != rateNumber) {
            return ResponseEntity.badRequest().body(false);
        }

        return ResponseEntity.ok(true);
    }

    /*
     * Get the rating of a film by a user.
     * @Param filmId: The id of the film.
     * @Param userId: The id of the user.
     * 
     * @Return: The rating of the film by the user.
     */
    @GetMapping("user/film/film-cell/rated")
    @ResponseBody
    public Integer getRated (@RequestParam Integer filmId, @RequestParam Integer userId) {
        StarRatedEntity starRated = filmService.getRatingByUser(filmId, userId);
        if (starRated == null) {
            return 0;
        }

        return starRated.getStarNumber();
    }
    

    /*
     * This method is used to get the child comments of a comment.
     * It takes in the commentId as a parameter.
     * It returns the film-cell.html page.
     * 
     * This page contains atrributes:
     * - ChildComments
     * 
     * @Param commentId: The id of the comment.
     * 
     * @Return: The film-cell.html page.
     */
    @Deprecated
    @GetMapping("user/film/film-cell/comment/replies")
    @ResponseBody
    public String getChildsComment(@RequestParam Integer commentId, Model model) {
        List<CommentEntity> commentEntities = commentService.getCommentsByParentCommentId(commentId);

        model.addAttribute("ChildComments", commentEntities);

        return "film/film-cell";
    }    
}
