package com.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.dto.LoanDTO;
import com.librarymanagementsystem.dto.LoanMapper;
import com.librarymanagementsystem.entities.Loan;
import com.librarymanagementsystem.repository.LoanRepository;
import com.librarymanagementsystem.service.BookService;
import com.librarymanagementsystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;


    @Autowired
    private LoanMapper loanMapper;

    public LoanDTO createLoan(LoanDTO loanDTO) {
        Loan loan = loanMapper.toEntity(loanDTO);
        loan = loanRepository.save(loan);
        return loanMapper.toDTO(loan);
    }

    public LoanDTO updateLoan(Long id, LoanDTO loanDTO) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            loan.setLoanDate(loanDTO.getLoanDate());
            loan.setReturnDate(loanDTO.getReturnDate());
            // Update other fields as necessary
            loan = loanRepository.save(loan);
            return loanMapper.toDTO(loan);
        } else {
            return null;
        }
    }

    public LoanDTO getLoanById(Long id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        return optionalLoan.map(loanMapper::toDTO).orElse(null);
    }

    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(loanMapper::toDTO)
                .collect(Collectors.toList());
    }

    public boolean deleteLoan(Long id) {
        if (loanRepository.existsById(id)) {
            loanRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
