package com.k8s.bookstore.adminapp.repository;

import com.k8s.bookstore.adminapp.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}
