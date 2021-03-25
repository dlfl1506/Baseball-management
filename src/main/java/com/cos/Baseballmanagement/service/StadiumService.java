package com.cos.Baseballmanagement.service;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Baseballmanagement.domain.player.Player;
import com.cos.Baseballmanagement.domain.stadium.Stadium;
import com.cos.Baseballmanagement.domain.stadium.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StadiumService {
	
	private final StadiumRepository stadiumRepository;
	
	
	@Transactional(readOnly = true)
	public List<Stadium> 야구장리스트가져오기(){
		return stadiumRepository.findAll();
	}
	@Transactional
	public Stadium 야구장등록(Stadium stadium) {
		return stadiumRepository.save(stadium);
	}
	
	@Transactional
	public void 야구장삭제하기(int id) {
		stadiumRepository.deleteById(id);
	}
	
}
