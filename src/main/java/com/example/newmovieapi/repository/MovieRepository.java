package com.example.newmovieapi.repository;

import com.example.newmovieapi.model.Movie;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	// filtrar por titulo
	@Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
	List<Movie> findTitle(@Param("title") String title);

	// filtrar los populares
	@Query("SELECT m FROM Movie m ORDER BY m.rate DESC")
	List<Movie> findPopular(PageRequest pageRequest);

	// filtrar por clasificación
	@Query("SELECT m FROM Movie m WHERE m.classified LIKE %:classified%")
	List<Movie> findClass(@Param("classified") String classified);
}
