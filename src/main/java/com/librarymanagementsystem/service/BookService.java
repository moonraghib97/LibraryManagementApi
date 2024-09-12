package com.librarymanagementsystem.service;

import com.librarymanagementsystem.dto.BookDTO;
import com.librarymanagementsystem.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(BookDTO book);

    BookDTO updateBook(Long id, BookDTO bookDTO);

    void deleteById(Long id);
}
