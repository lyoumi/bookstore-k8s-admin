package com.k8s.bookstore.adminapp.repository;

import com.k8s.bookstore.adminapp.data.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, String> {

    Genre getGenreByName(String geneName);

}
