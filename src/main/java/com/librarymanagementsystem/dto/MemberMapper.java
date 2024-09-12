package com.librarymanagementsystem.dto;

import com.librarymanagementsystem.entities.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public MemberDTO toDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setName(member.getName());
        memberDTO.setEmail(member.getEmail());
        return memberDTO;
    }

    public Member toEntity(MemberDTO memberDTO) {
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        return member;
    }
}

