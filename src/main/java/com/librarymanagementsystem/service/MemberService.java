package com.librarymanagementsystem.service;

import com.librarymanagementsystem.dto.MemberDTO;
import com.librarymanagementsystem.entities.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    MemberDTO createMember(MemberDTO memberDTO);

    MemberDTO updateMember(Long id, MemberDTO memberDTO);

    MemberDTO getMemberById(Long id);

    List<MemberDTO> getAllMembers();

    boolean deleteMember(Long id);

}
