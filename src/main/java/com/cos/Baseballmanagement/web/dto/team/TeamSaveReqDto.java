package com.cos.Baseballmanagement.web.dto.team;

import java.util.List;

import com.cos.Baseballmanagement.domain.player.Player;
import com.cos.Baseballmanagement.domain.stadium.Stadium;
import com.cos.Baseballmanagement.domain.team.Team;

import lombok.Data;

@Data
public class TeamSaveReqDto {
	private String teamName;
	private Integer stadiumId;

	public Team toEntity() {
		return Team.builder().teamName(teamName).stadium(Stadium.builder().id(stadiumId).build()).build();
	}
}
