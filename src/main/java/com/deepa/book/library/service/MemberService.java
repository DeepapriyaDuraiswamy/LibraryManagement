package com.deepa.book.library.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepa.book.library.dto.MemberDto;
import com.deepa.book.library.entities.MemberEntity;
import com.deepa.book.library.repo.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
    private MemberRepository memberRepository;

    public List<MemberDto> getAllMembers() {
        List<MemberEntity> members = memberRepository.findAll();

        return members.stream().map(member -> {
        	MemberDto memberDto = new MemberDto();
        	memberDto.setId(member.getId());
        	memberDto.setFirstName(member.getFirstName());
        	memberDto.setLastName(member.getLastName());
        	//memberDto.setJoinedDate(member.getJoinedDate());
        	memberDto.setJoinedDate(convertLocalDateToDate(member.getJoinedDate()));
        	memberDto.setActiveStatusId(member.getActiveStatusId());
            return memberDto;
        }).collect(Collectors.toList());
    }
    
    public MemberDto addUser(MemberDto memberDto) {
        MemberEntity entity = convertDtoToEntity(memberDto);
        MemberEntity savedEntity = memberRepository.save(entity);
        return convertEntityToDto(savedEntity);
    }
    
    public MemberDto updateUser(int id, MemberDto memberDto) {
        MemberEntity entity = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        entity.setFirstName(memberDto.getFirstName());
        entity.setLastName(memberDto.getLastName());

        if (memberDto.getJoinedDate() != null) {
            entity.setJoinedDate(convertDateToLocalDate(memberDto.getJoinedDate()));
        }

        entity.setActiveStatusId(memberDto.getActiveStatusId());

        MemberEntity updatedEntity = memberRepository.save(entity);
        return convertEntityToDto(updatedEntity);
    }

   
    private MemberEntity convertDtoToEntity(MemberDto memberDto) {
        MemberEntity entity = new MemberEntity();
        entity.setFirstName(memberDto.getFirstName());
        entity.setLastName(memberDto.getLastName());
        if (memberDto.getJoinedDate() != null) {
            entity.setJoinedDate(convertDateToLocalDate(memberDto.getJoinedDate()));
        }
        entity.setActiveStatusId(memberDto.getActiveStatusId());
        return entity;
    }

    private MemberDto convertEntityToDto(MemberEntity entity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(entity.getId()); 
        memberDto.setFirstName(entity.getFirstName());
        memberDto.setLastName(entity.getLastName());
        memberDto.setJoinedDate(convertLocalDateToDate(entity.getJoinedDate()));
        memberDto.setActiveStatusId(entity.getActiveStatusId());
        return memberDto;
    }


    private LocalDate convertDateToLocalDate(Date date) {
	    return date.toInstant()
	               .atZone(ZoneId.systemDefault())
	               .toLocalDate();
	}

    private Date convertLocalDateToDate(LocalDate localDate) {
	    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

}
