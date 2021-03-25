package com.cos.Baseballmanagement.web.dto.player;

import com.cos.Baseballmanagement.domain.player.Player;
import com.cos.Baseballmanagement.domain.team.Team;

import lombok.Data;

@Data
public class PlayerSaveReqDto {

	private String playerName;
	private String position;
	private Integer teamId;

	public Player toEntity() {
		return Player.builder().playerName(playerName).position(position).team(Team.builder().id(teamId).build())
				.build();
	}
}
