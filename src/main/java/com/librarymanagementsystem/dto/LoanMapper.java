package com.librarymanagementsystem.dto;


import com.librarymanagementsystem.entities.Copy;
import com.librarymanagementsystem.entities.Loan;
import com.librarymanagementsystem.entities.Member;
import com.librarymanagementsystem.repository.CopyRepository;
import com.librarymanagementsystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class LoanMapper {

    @Autowired
    CopyRepository copyRepository;

    @Autowired
    MemberRepository memberRepository;

    public LoanDTO toDTO(Loan loan) {
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setId(loan.getId());
        loanDTO.setLoanDate(loan.getLoanDate());
        loanDTO.setReturnDate(loan.getReturnDate());
        if(loan.getCopy() == null){
            System.out.println("No copy against Loan: " + loan.getId());
        }
        else {
            System.out.println("Copy found against Loan: " + loan.getId());
            loanDTO.setCopyId(loan.getCopy().getId());
        }
        if(loan.getMember() == null){
            System.out.println("No member found against Loan: " + loan.getId());
        }
        else {
            loanDTO.setMemberId(loan.getMember().getId());
            System.out.println("Member found against Loan: " + loan.getId());
        }
//        loanDTO.setMemberId(loan.getMember().getId());
        return loanDTO;
    }

    public Loan toEntity(LoanDTO loanDTO) {
        Loan loan = new Loan();
        loan.setId(loanDTO.getId());
        loan.setLoanDate(loanDTO.getLoanDate());
        loan.setReturnDate(loanDTO.getReturnDate());

        Copy copy = copyRepository.findById(loanDTO.getCopyId())
                .orElseThrow(() -> new EntityNotFoundException("Copy not found"));
        System.out.println("Found a copy with its ID: " + copy.getId());

        Member member = memberRepository.findById(loanDTO.getMemberId())
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));
        System.out.println("Found a Member with its ID: " + member.getId());


        loan.setCopy(copy);
        loan.setMember(member);

        System.out.println("HOPE TO SEE NO ERRORS NOW -------- Copy: " + loan.getCopy().getStatus() +
                " Member: " + loan.getMember().getName());
        // You need to fetch and set the Copy and Member entities based on the IDs
//        loan.setCopy(loanDTO.getCopyId());
        return loan;
    }
}

