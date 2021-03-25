package com.cos.Baseballmanagement.web.dto.stadium;

import com.cos.Baseballmanagement.domain.stadium.Stadium;

import lombok.Data;

@Data
public class StadiumSaveReqDto {
	private String name;
	
	public Stadium toEntity() {
		return Stadium.builder().name(name).build();
	}
}