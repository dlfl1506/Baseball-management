package com.cos.Baseballmanagement.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.Baseballmanagement.domain.player.Player;

public interface TeamRepository extends JpaRepository<Team, Integer>{


}
