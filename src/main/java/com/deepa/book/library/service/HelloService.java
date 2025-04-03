package com.deepa.book.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepa.book.library.dto.HelloDto;
import com.deepa.book.library.repo.HelloRepository;

@Service
public class HelloService {
	
	@Autowired 
	public HelloRepository helloRepository;


	public List<HelloDto> getTableData() { 
		
		List<HelloDto> res = new ArrayList<HelloDto>();
		
		helloRepository.findAll().forEach((entity) -> 
		{
			HelloDto dto = new HelloDto();
			dto.setName(entity.getTestColumn1());
			//dto.setUid(entity.getId());
			res.add(dto);
		}
		
				
				);
		
	return res;
                
	  }
	 
	
	public List<String> getTableDataById(Long id) {
        return helloRepository.findById(id)
                .map(entity -> List.of(entity.getTestColumn1()))
                .orElse(List.of()); // Returns an empty list if no record is found
    }
	
	public List<String> getTableDataWithQuery() {
		return helloRepository.getTableDataWithQuery();
    }

}
