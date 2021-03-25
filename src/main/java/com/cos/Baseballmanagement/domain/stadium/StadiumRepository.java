package com.cos.Baseballmanagement.domain.stadium;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.Baseballmanagement.domain.player.Player;

public interface StadiumRepository extends JpaRepository<Stadium, Integer>{

	
}
