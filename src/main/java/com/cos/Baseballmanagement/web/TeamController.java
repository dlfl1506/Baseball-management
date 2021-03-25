package com.cos.Baseballmanagement.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.Baseballmanagement.domain.player.Player;
import com.cos.Baseballmanagement.domain.player.PlayerRepository;
import com.cos.Baseballmanagement.domain.stadium.Stadium;
import com.cos.Baseballmanagement.domain.team.Team;
import com.cos.Baseballmanagement.service.PlayerService;
import com.cos.Baseballmanagement.service.StadiumService;
import com.cos.Baseballmanagement.service.TeamService;
import com.cos.Baseballmanagement.web.dto.player.PlayerSaveReqDto;
import com.cos.Baseballmanagement.web.dto.team.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {
	private final TeamService teamService;
	private final StadiumService stadiumService;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/team")
	public String list(Model model) {
		List<Team> teams= teamService.팀리스트가져오기();
		model.addAttribute("teams", teams);
		return "team/list";
	}

	@GetMapping("/team/saveForm")
	public String saveForm(Model model) {
		List<Stadium> stadiums = stadiumService.야구장리스트가져오기();
		model.addAttribute("stadiums", stadiums);
		return "team/saveForm";
	}

	@PostMapping("/team")
	public String save(String teamName, int stadiumId) {
		TeamSaveReqDto teamSaveReqDto = new TeamSaveReqDto();
		teamSaveReqDto.setTeamName(teamName);
		teamSaveReqDto.setStadiumId(stadiumId);
		teamService.팀등록(teamSaveReqDto.toEntity());
		return "redirect:/team";
	}

	@DeleteMapping("/team/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		teamService.팀삭제(id);
		return "ok";
	}

}
