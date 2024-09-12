package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.dto.LoanDTO;
import com.librarymanagementsystem.service.CopyService;
import com.librarymanagementsystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;


    @PostMapping
    public ResponseEntity<LoanDTO> createLoan(@Valid @RequestBody LoanDTO loanDTO) {
        LoanDTO createdLoan = loanService.createLoan(loanDTO);
        return ResponseEntity.ok(createdLoan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanDTO> updateLoan(@PathVariable Long id, @Valid @RequestBody LoanDTO loanDTO) {
        LoanDTO updatedLoan = loanService.updateLoan(id, loanDTO);
        if (updatedLoan != null) {
            return ResponseEntity.ok(updatedLoan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDTO> getLoanById(@PathVariable Long id) {
        LoanDTO loanDTO = loanService.getLoanById(id);
        if (loanDTO != null) {
            return ResponseEntity.ok(loanDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<LoanDTO>> getAllLoans() {
        List<LoanDTO> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        boolean isDeleted = loanService.deleteLoan(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
