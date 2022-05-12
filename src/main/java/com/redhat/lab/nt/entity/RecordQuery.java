package com.redhat.lab.nt.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordQuery {

	
	private String accountNo;
	private String startDate;
	private String endDate;

}