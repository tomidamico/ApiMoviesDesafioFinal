package com.example.newmovieapi.service;

import com.example.newmovieapi.model.Movie;
import com.example.newmovieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

	private final MovieRepository movieRepository;

	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	// HTML inicial
	public String init() {
		return "<h1>Bienvenido a mi API de Peliculas<h1>";
	};

	// Devuelvo el listado de peliculas
	public List<Movie> getMovies() {
		return movieRepository.findAll();
	}

	// Agrega una pelicula a la BD
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	// Elimina una pelicual de la BD
	public void deleteMovie(Integer id) {
		Optional<Movie> peliDelete = movieRepository.findById(id);
		if (!peliDelete.isEmpty()) {
			movieRepository.deleteById(id);
		} else {
			throw new RuntimeException("No existe la pelicula a eliminar");
		}
	}

	// Actualiza una pelicula de la BD
	public Movie updateMovie(Movie movie, Integer id) {

		Optional<Movie> peliUptade = movieRepository.findById(id);

		if (!peliUptade.isEmpty()) {
			return movieRepository.save(movie);
		} else {
			throw new RuntimeException("No existe la pelicula a actualizar");
		}
	}

	// Busca una pelicula por su ID
	public Optional<Movie> findId(Integer id) {
		Optional<Movie> peliToFind = movieRepository.findById(id);
		if (!peliToFind.isEmpty()) {
			return peliToFind;
		} else {
			throw new RuntimeException("No existe la pelicula a eliminar");
		}
	}

	// Busca una pelicula por su titulo
	public List<Movie> findTitle(String title) {
		return movieRepository.findTitle(title);
	}

	// Busca una pelicula por popularidad
	public List<Movie> findPopular() {
		return movieRepository.findPopular(PageRequest.of(0, 3));
	}

	// Busca una pelicula por su clase
	public List<Movie> findClass(String classified) {
		return movieRepository.findClass(classified);
	}

}
