package com.cos.Baseballmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Baseballmanagement.domain.stadium.Stadium;
import com.cos.Baseballmanagement.domain.team.Team;
import com.cos.Baseballmanagement.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	private final TeamRepository teamRepository;

	@Transactional(readOnly = true)
	public List<Team> 팀리스트가져오기() {
		return teamRepository.findAll();
	}

	@Transactional
	public Team 팀등록(Team team) {
		return teamRepository.save(team);
	}

	@Transactional
	public void 팀삭제(int id) {
		teamRepository.deleteById(id);
	}

}
