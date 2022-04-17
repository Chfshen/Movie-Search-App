package com.changfeng.movieweb;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MovieDAO {

    private String apiKey = "f79a9b7";
    private String apiPrefix = "http://www.omdbapi.com/";

    @Autowired
	private MovieRepository movieRepo;

    private Movie getMovieFromUrl(String urlstr) {
        Movie movie = new Movie();

        try {
            URL url = new URL(urlstr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode != 200) {
                return movie;
            }

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNextLine()) {
                inline += scanner.nextLine();
            }
            scanner.close();

            JSONObject obj = new JSONObject(inline);
            if (obj.get("Response").equals("False")) {
                return movie;
            }

            movie.setId((String) obj.get("imdbID"));
            movie.setTitle((String) obj.get("Title"));
            movie.setDesc((String) obj.get("Plot"));
            movie.setPoster((String) obj.get("Poster"));

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return movie;
    }

    private MovieDB getMovieFromDB(String id) {
        MovieDB movie = movieRepo.findOneById(id);
        return movie;
    }

    public Movie getMovieByTitle(String content) {
        String urlstr = apiPrefix + "?t=" + content + "&apikey=" + apiKey;
        Movie movie = getMovieFromUrl(urlstr);

        MovieDB movieDB = getMovieFromDB(movie.getId());
        if (movieDB == null) {
            movieDB = new MovieDB();
            movieDB.setLike(0);
            movieDB.setDislike(0);
        }

        movie.setLike(movieDB.getLike());
        movie.setDislike(movieDB.getDislike());
        
        return movie;
    }
}
