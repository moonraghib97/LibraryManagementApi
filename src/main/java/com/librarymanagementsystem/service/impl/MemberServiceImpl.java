package com.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.dto.MemberDTO;
import com.librarymanagementsystem.dto.MemberMapper;
import com.librarymanagementsystem.entities.Member;
import com.librarymanagementsystem.repository.MemberRepository;
import com.librarymanagementsystem.service.BookService;
import com.librarymanagementsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberMapper memberMapper;

    public MemberDTO createMember(MemberDTO memberDTO) {
        Member member = memberMapper.toEntity(memberDTO);
        member = memberRepository.save(member);
        return memberMapper.toDTO(member);
    }

    public MemberDTO updateMember(Long id, MemberDTO memberDTO) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setName(memberDTO.getName());
            member.setEmail(memberDTO.getEmail());
            // Update other fields as necessary
            member = memberRepository.save(member);
            return memberMapper.toDTO(member);
        } else {
            return null;
        }
    }

    public MemberDTO getMemberById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        return optionalMember.map(memberMapper::toDTO).orElse(null);
    }

    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(memberMapper::toDTO)
                .collect(Collectors.toList());
    }

    public boolean deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
