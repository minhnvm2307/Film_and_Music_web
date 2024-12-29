package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.data.model.FilmDTO;
import com.example.data.model.converter.FilmConverter;
import com.example.data.service.FilmCategoryService;
import com.example.data.service.FilmService;
import com.example.data.service.UserService;

@Controller
public class FilmController {
    private static final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmCategoryService filmCategoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(@RequestParam String username, Model model) {

        // Add the list to the model
        model.addAttribute("Films", filmService.findAll());

        model.addAttribute("FilmsWithRating", filmService.getFilmsWithRatings());

        model.addAttribute("User", userService.getUserByUsername(username));

        return "index";
    }

    @GetMapping("/film/film-page")
    public String filmPage(@RequestParam String username, Model model) {
        model.addAttribute("FilmsWithRating", filmService.getFilmsWithRatings());

        model.addAttribute("categories", filmCategoryService.findAll());

        model.addAttribute("User", userService.getUserByUsername(username));

        return "film/film-page";
    }

    /*
     * Filter films by category
     * @Param categoryId (can be null if no category is selected)
     * @Return List of films (filterd)
     */
    @GetMapping("/user/film/filter")
    @ResponseBody
    public List<FilmDTO> getFilmsByCategory(@RequestParam(value = "categoryId", required = false) Integer categoryId) {
        logger.info("getFilmsByCategory: categoryId = " + categoryId);
        
        try {
            if (categoryId != null) {
                List<FilmDTO> films = filmService.getFilmsByCategory(categoryId);
                logger.info("Found " + films.size() + " films for categoryId = " + categoryId);
                return films;
            }
            
            List<FilmDTO> filmDTOs = FilmConverter.convertFromEntityList(filmService.findAll());
            logger.info("Found " + filmDTOs.size() + " films in total.");
            return filmDTOs;
        } catch (Exception e) {
            logger.error("Error in getFilmsByCategory: ", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to fetch films", e);
        }
    }
}
