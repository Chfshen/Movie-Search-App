package com.changfeng.movieweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieDAO movieDAO;

    @GetMapping("/api/movies")
    public Movie getMovie(@RequestParam(value="content", defaultValue="")String content) {
        Movie theMovie = movieDAO.getMovieByTitle(content);
        System.out.println("Get Request: "+content);
        return theMovie;
    }

    @PutMapping("/api/movies")
    public ResponseEntity<Movie> putMovie(@RequestParam(value="id", defaultValue="")String id, @RequestParam(value="opt", defaultValue="")String opt) {
        Movie theMovie;
        System.out.println("Put Request: "+opt);
        if (opt.equals("like")) theMovie = movieDAO.getMovieAndLike(id);
        else if (opt.equals("dislike")) theMovie = movieDAO.getMovieAndDislike(id);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Movie());
        return ResponseEntity.status(HttpStatus.OK).body(theMovie);
    }

    @DeleteMapping("/api/movies")
    public ResponseEntity<String> deleteMovie() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @PostMapping("/api/movies")
    public ResponseEntity<String> postMovie() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }
    
}
