package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.entities.Copy;
import com.librarymanagementsystem.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
