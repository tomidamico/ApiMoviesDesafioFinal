package com.example.newmovieapi.controller;

import com.example.newmovieapi.model.Movie;
import com.example.newmovieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("apiMovie/v1")
@RestController
public class MovieController {

	private final MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/movies")
	public List<Movie> getMovies() {
		return movieService.getMovies();
	}

	@PostMapping("/addMovie")
	public Movie createMovie(@RequestBody Movie movie) {
		return movieService.createMovie(movie);
	}

	@DeleteMapping("/deleteMovie/{id}")
	public void deleteMovie(@PathVariable Integer id) {
		movieService.deleteMovie(id);
	}

	@PutMapping("/updateMovie/{id}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable Integer id) {
		return movieService.updateMovie(movie, id);
	}

	// metodo para buscar por id
	@GetMapping("/searchId/{id}")
	public Optional<Movie> findId(@PathVariable Integer id) {
		return movieService.findId(id);
	}

	// metodo para buscar por titulo
	@GetMapping("/searchTitle/{title}")
	public List<Movie> findTitle(@PathVariable String title) {
		return movieService.findTitle(title);
	}

	// metodo para buscar las mas populares
	@GetMapping("/searchPopular/{title}")
	public List<Movie> findPopular() {
		return movieService.findPopular();
	}

	// metodo para buscar las peliculas por clasificación
	@GetMapping("/searchClassified/{classified}")
	public List<Movie> findClass(@PathVariable String classified) {
		return movieService.findClass(classified);
	}
}
