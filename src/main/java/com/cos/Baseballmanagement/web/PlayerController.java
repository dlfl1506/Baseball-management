package com.cos.Baseballmanagement.web;

import java.util.List;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.Baseballmanagement.domain.player.Player;
import com.cos.Baseballmanagement.domain.team.Team;
import com.cos.Baseballmanagement.service.PlayerService;
import com.cos.Baseballmanagement.service.TeamService;
import com.cos.Baseballmanagement.web.dto.player.PlayerSaveReqDto;
import com.cos.Baseballmanagement.web.dto.position.PosiRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {

	private final PlayerService playerService;
	private final TeamService teamService;

	@GetMapping("/player")
	public String list(Model model) {
		List<Player> players = playerService.선수리스트가져오기();
		model.addAttribute("players", players);
		return "player/list";
	}

	@GetMapping("/player/position")
	public String 포지션별검색(Model model) {
		JpaResultMapper jpaResultMapper = new JpaResultMapper();
		List<PosiRespDto> dto= jpaResultMapper.list(playerService.포지션별선수검색(), PosiRespDto.class);
		System.out.println(dto);
		model.addAttribute("dto", dto);
		return "position";
	}
	

	@GetMapping("/player/saveForm")
	public String saveForm(Model model) {
		List<Team> teams = teamService.팀리스트가져오기();
		model.addAttribute("teams", teams);
		return "player/saveForm";
	}

	@PostMapping("/player")
	public String save(String playerName, String position, int teamId) {
		PlayerSaveReqDto playerSaveReqDto = new PlayerSaveReqDto();
		playerSaveReqDto.setPlayerName(playerName);
		playerSaveReqDto.setPosition(position);
		playerSaveReqDto.setTeamId(teamId);
		playerService.선수등록(playerSaveReqDto.toEntity());

		return "redirect:/player";
	}

	@DeleteMapping("/player/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		playerService.삭제하기(id);
		return "ok";
	}
}
