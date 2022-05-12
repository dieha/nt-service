package com.redhat.lab.nt.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deposit")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Deposit {

	@Id
	@Column(name = "account_no")
	@NotNull(message = "account_no is mandatory")
	private String accountNo;

	@Column(name = "account_id")
	private Long accountId;

	@Column(name = "currency")
	private String currency;

	@Column(name = "amount")
	private BigDecimal amount;

	public static Deposit of(Long accountId) {

		return new Deposit(null, accountId, null, null);

	}

}