package com.cos.Baseballmanagement.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Baseballmanagement.domain.player.Player;
import com.cos.Baseballmanagement.domain.player.PlayerRepository;
import com.cos.Baseballmanagement.web.dto.position.PosiRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	private final PlayerRepository playerRepository;
	private final EntityManager em;

	@Transactional
	public Player 선수등록(Player player) {
		return playerRepository.save(player);
	}

	@Transactional(readOnly = true)
	public List<Player> 선수리스트가져오기() {
		return playerRepository.findAll();
	}

	@Transactional
	public void 삭제하기(int id) {
		playerRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Query 포지션별선수검색() {
		StringBuffer sb = new StringBuffer();
		sb.append("select p.position as 'position', ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 11 THEN p.playerName ELSE null END)) as 'lotte', ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 12 THEN p.playerName ELSE null END)) as 'lg', ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 13 THEN p.playerName  ELSE null END)) as 'kt' ");
		sb.append("from player p GROUP BY p.position");
		Query query = em.createNativeQuery(sb.toString());
		return query;
	}

}
