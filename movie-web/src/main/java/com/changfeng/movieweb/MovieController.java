package com.changfeng.movieweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieDAO movieDAO;

    @GetMapping("/api/movies")
    public Movie getMovie(@RequestParam(value="content", defaultValue="")String content) {
        Movie theMovie = movieDAO.getMovieByTitle(content);
        return theMovie;
    }

    @PostMapping("/api/movies")
    public ResponseEntity<String> postMovie() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @DeleteMapping("/api/movies")
    public ResponseEntity<String> deleteMovie() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @PutMapping("/api/movies")
    public ResponseEntity<String> putMovie() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }
    
}
