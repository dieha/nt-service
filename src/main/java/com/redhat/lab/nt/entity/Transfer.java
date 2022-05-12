package com.redhat.lab.nt.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transfer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transfer {

	@Id
	@Column(name = "transfer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String transferId;

	@Column(name = "form_account_no")
	private String formAccountNo;
	@Column(name = "to_bank_code")
	private String toBankCode;
	@Column(name = "to_account_no")
	private String toAccountNo;
	@Column(name = "currency")
	private String currency;
	@Column(name = "amount")
	private BigDecimal amount;
	@Column(name = "status")
	private String status;
	@JsonIgnore
	@Column(name = "transfer_date")
	private Timestamp transferDate;
	@JsonIgnore
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@Transient
	private String transferDateS;


}