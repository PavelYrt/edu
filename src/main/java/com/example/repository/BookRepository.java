package com.example.repository;

import com.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Genre;


public interface BookRepository extends JpaRepository<Book, Long> {

}
