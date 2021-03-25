package com.cos.Baseballmanagement.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.Baseballmanagement.domain.player.Player;
import com.cos.Baseballmanagement.domain.stadium.Stadium;
import com.cos.Baseballmanagement.service.StadiumService;
import com.cos.Baseballmanagement.web.dto.player.PlayerSaveReqDto;
import com.cos.Baseballmanagement.web.dto.stadium.StadiumSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StadiumController {
	private final StadiumService stadiumService;
	
	@GetMapping("/stadium")
	public String findAll(Model model) {
		List<Stadium> stadiums =stadiumService.야구장리스트가져오기();
		model.addAttribute("stadiums",stadiums);
		return "stadium/list";
	}
	
	@GetMapping("/stadium/saveForm")
	public String saveForm() {
		return "stadium/saveForm";
	}
	
	@PostMapping("/stadium")
	public String save(String name) {
		StadiumSaveReqDto  stadiumSaveReqDto = new StadiumSaveReqDto();
		stadiumSaveReqDto.setName(name);
		stadiumService.야구장등록(stadiumSaveReqDto.toEntity());
		return "redirect:/stadium";
	}
	
	@DeleteMapping("/stadium/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		stadiumService.야구장삭제하기(id);
		return "ok";
	}

}
