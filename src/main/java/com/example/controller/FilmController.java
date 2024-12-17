package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.data.service.FilmService;
import com.example.data.service.UserService;
import com.example.data.entity.FilmEntity;
import com.example.data.service.FilmCategoryService;

@Controller
public class FilmController {
    private static final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmCategoryService filmCategoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/serial")
    public String serial(Model model) {
        // model.addAttribute("Films", filmService.findSerialFilms());
        return "films/serial";
    }

    @GetMapping("/theaters")
    public String theaters(Model model) {
        // model.addAttribute("Films", filmService.findTheaterFilms());
        return "films/theaters";
    }

    @GetMapping("/popular")
    public String popular(Model model) {
        // model.addAttribute("Films", filmService.findPopularFilms());
        return "films/popular";
    }

    @GetMapping("/index")
    public String index(@RequestParam String username, Model model) {

        // Add the list to the model
        model.addAttribute("Films", filmService.findAll());

        model.addAttribute("FilmsWithRating", filmService.getFilmsWithRatings());

        model.addAttribute("User", userService.getUserByUsername(username));

        return "index";
    }

    @GetMapping("/film/film-page")
    public String filmPage(Model model) {
        model.addAttribute("FilmsWithRating", filmService.getFilmsWithRatings());

        model.addAttribute("categories", filmCategoryService.findAll());

        return "film/film-page";
    }

    @GetMapping("/user/film/filter")
    @ResponseBody
    public List<FilmEntity> getFilmsByCategory(@RequestParam(value = "categoryId", required = false) Integer categoryId) {
        logger.info("getFilmsByCategory: categoryId = " + categoryId);
        
        if (categoryId != null) {
            return filmService.getFilmsByCategory(categoryId);
        }
        return filmService.findAll();
    }
}
