package com.mera.netflixapi.repository;

import com.mera.netflixapi.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByCategory(String category);
}