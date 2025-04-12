package com.deepa.book.library.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepa.book.library.dto.MemberDto;
import com.deepa.book.library.service.MemberService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public List<MemberDto> getAllMembers() {
        return memberService.getAllMembers();
    }
    
	@PostMapping("/adduser")
	public MemberDto addUser(@RequestBody MemberDto request) {
		return memberService.addUser(request);
	}
	
	@PutMapping("/updateuser/{id}")
	public MemberDto updateUser(@PathVariable int id, @RequestBody MemberDto memberDto) {
	    return memberService.updateUser(id, memberDto);
	}
}
