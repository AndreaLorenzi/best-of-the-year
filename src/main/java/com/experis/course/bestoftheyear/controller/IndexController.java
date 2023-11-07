package com.experis.course.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

    //step 1

    @GetMapping("home")
    public String home(Model model) {
        String yourName = "Andrea Lorenzi";
        model.addAttribute("title", "Best of the year" + yourName);
        return "home";
    }

    // secondo step
    private List<String> getBestMovies() {
        // Metodo privato per ottenere la lista dei migliori film
        return Arrays.asList("Cado dalle nubi", "Deadpool", "ENDGAME", "Spiderman", "Captain America");
    }

    private List<String> getBestSongs() {
        // Metodo privato per ottenere la lista delle migliori canzoni
        return Arrays.asList("Sky and sand", "Despacito", "Waka Waka", "Rap God", "Young Wild and Free");
    }

    @GetMapping("/movies")
    public String getBestMoviesPage(Model model) {
        List<String> bestMovies = getBestMovies();
        model.addAttribute("movies", String.join(", ", bestMovies));
        return "movies";
    }

    @GetMapping("/songs")
    public String getBestSongsPage(Model model) {
        List<String> bestSongs = getBestSongs();
        model.addAttribute("songs", String.join(", ", bestSongs));
        return "songs";
    }

}
