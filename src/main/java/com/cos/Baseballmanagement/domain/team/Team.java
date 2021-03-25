package com.cos.Baseballmanagement.domain.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cos.Baseballmanagement.domain.player.Player;
import com.cos.Baseballmanagement.domain.stadium.Stadium;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String teamName;

	@OneToMany(mappedBy = "team")
	private List<Player> players;

	@OneToOne
	@JoinColumn(name = "stadiumId")
	private Stadium stadium;

}
