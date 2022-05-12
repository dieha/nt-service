package com.redhat.lab.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bank_code")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankCode {

	@Id
	@Column(name = "code", length = 3)
	private String code;

	@Column(name = "bank_name", length = 20)
	private String bankName;

}