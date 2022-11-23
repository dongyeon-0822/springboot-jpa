package com.example.springbootjpa.repository;

import com.example.springbootjpa.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
