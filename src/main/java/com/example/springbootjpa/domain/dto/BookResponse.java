package com.example.springbootjpa.domain.dto;

import com.example.springbootjpa.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long bookId;
    private String bookName;
    private String authorName;
    private String publisherName;


    public static BookResponse of(Book book) { //매개변수로 book과 작가명을 받아 Response 생성
        return BookResponse.builder()
                .bookId(book.getId())
                .bookName(book.getName())
                .authorName(book.getAuthor().getName())
                .publisherName(book.getPublisher().getName())
                .build();
    }

}
