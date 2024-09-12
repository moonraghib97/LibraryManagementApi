package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.entities.Book;
import com.librarymanagementsystem.entities.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {
    Book findBookById(Long bookId);

    List<Copy> findByBookId(Long bookId);
}
