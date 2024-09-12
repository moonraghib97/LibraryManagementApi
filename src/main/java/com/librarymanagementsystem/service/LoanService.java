package com.librarymanagementsystem.service;

import com.librarymanagementsystem.dto.LoanDTO;
import com.librarymanagementsystem.entities.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {

    LoanDTO createLoan(LoanDTO loanDTO);

    LoanDTO updateLoan(Long id, LoanDTO loanDTO);

    LoanDTO getLoanById(Long id);

    List<LoanDTO> getAllLoans();

    boolean deleteLoan(Long id);
}
