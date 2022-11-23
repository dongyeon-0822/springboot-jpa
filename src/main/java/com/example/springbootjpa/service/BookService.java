package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.BookResponse;
import com.example.springbootjpa.domain.entity.Author;
import com.example.springbootjpa.domain.entity.Book;
import com.example.springbootjpa.repository.AuthorRepository;
import com.example.springbootjpa.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class BookService {
    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookResponse> findBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookResponses = books.stream() //book을 받아서 bookResponse로 바꾸는 과정
                .map(book -> BookResponse.of(book)).collect(Collectors.toList());
        return bookResponses;
    }
}
