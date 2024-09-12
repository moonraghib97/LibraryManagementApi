package com.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.dto.BookDTO;
import com.librarymanagementsystem.entities.Book;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(BookDTO book) {
        Book bookToBeSaved = new Book();
        bookToBeSaved.setAuthor(book.getAuthor());
        bookToBeSaved.setTitle(book.getTitle());
        bookToBeSaved.setIsbn(book.getIsbn());
        return bookRepository.save(bookToBeSaved);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();

            // Update existingBook with data from bookDTO
            existingBook.setTitle(bookDTO.getTitle());
            existingBook.setAuthor(bookDTO.getAuthor());
            existingBook.setIsbn(bookDTO.getIsbn());
            // Assuming copies updating logic if needed

            // Save the updated book entity
            Book updatedBook = bookRepository.save(existingBook);

            // Create and return BookDTO from updatedBook
            BookDTO updatedBookDTO = new BookDTO();
            BeanUtils.copyProperties(updatedBook, updatedBookDTO);
            return updatedBookDTO;
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
