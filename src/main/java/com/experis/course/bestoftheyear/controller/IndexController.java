package com.experis.course.bestoftheyear.controller;

import com.experis.course.bestoftheyear.model.Movie;
import com.experis.course.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private List<Movie> getBestMovies() {
        Movie[] bestMovies = {new Movie(1, "Cado dalle nubi"), new Movie(2, "Deadpool"), new Movie(3, "Endgame"), new Movie(4, "Spiderman"), new Movie(5, "Capitan America")};
        // Metodo privato per ottenere la lista dei migliori film
        return Arrays.asList(bestMovies);
    }

    private List<Song> getBestSongs() {
        Song[] bestSongs = {new Song(1, "Sky and sand"), new Song(2, "Despacito"), new Song(3, "Waka Waka"), new Song(4, "Rap God"), new Song(5, "Young Wild and Free")};
        // Metodo privato per ottenere la lista delle migliori canzoni
        return Arrays.asList(bestSongs);
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movie> bestMovies = getBestMovies();
        model.addAttribute("getBestMovies", bestMovies);
        return "movies";
    }

    @GetMapping("/songs")
    public String getSong(Model model) {
        List<Song> bestSongs = getBestSongs();
        model.addAttribute("getBestSongs", bestSongs);
        return "songs";
    }


    @GetMapping("/movies/{id}")
    public String showMovie(@PathVariable("id") int movieId, Model model) {

        for (Movie movie : getBestMovies()) {
            if (movie.getId() == movieId) {
                model.addAttribute("movie", movie);
            }
        }
        return "movie-details";
    }

    @GetMapping("/songs/{id}")
    public String showSong(@PathVariable("id") int songId, Model model) {
        for (Song song : getBestSongs()) {
            if (song.getId() == songId) {
                model.addAttribute("song", song);
            }
        }
        return "song-details";
    }
}