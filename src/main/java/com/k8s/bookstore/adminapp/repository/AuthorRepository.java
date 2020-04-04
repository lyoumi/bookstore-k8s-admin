package com.k8s.bookstore.adminapp.repository;

import com.k8s.bookstore.adminapp.data.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {

    Author findAuthorByName(String name);
}
