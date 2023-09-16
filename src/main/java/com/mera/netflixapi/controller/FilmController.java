package com.mera.netflixapi.controller;

import com.mera.netflixapi.entity.Film;
import com.mera.netflixapi.exception.NotFound;
import com.mera.netflixapi.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/film")
public class FilmController {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<Film> getAllMovies() {
        return filmRepository.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getSpecificFilm(@PathVariable int id) {
        Optional<Film> film = filmRepository.findById(id);

        if (film.isPresent()) {
            return ResponseEntity.ok(film.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFound("Film not found", "404"));
        }
    }

    @GetMapping("/category/{category}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getFilmByCategory(@PathVariable String category) {
        List<Film> films = filmRepository.findByCategory(category);
        if (films.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFound("Film not found", "404"));
        } else {
            return ResponseEntity.ok(films);
        }
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public Film addFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*")
    public String DeleteFilm(@PathVariable int id) {
        Optional<Film> film = filmRepository.findById(id);
        if (film.isPresent()) {
            filmRepository.delete(film.get());
            return "Film deleted successfully!";
        }else {
            return "Film not found";
        }
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "*")
    public Film updateFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

//    @PostMapping("/lol")
//    public List<Film> addAll(@RequestBody List<Film> films) {
//        return filmRepository.saveAll(films);
//    }


}
