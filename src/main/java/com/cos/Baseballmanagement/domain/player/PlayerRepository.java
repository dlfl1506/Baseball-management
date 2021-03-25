package com.cos.Baseballmanagement.domain.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.Baseballmanagement.domain.team.Team;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
