package com.redhat.lab.nt.entity;

import java.sql.Date;

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
@Table(name = "account")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {

	@Id
	@Column(name = "account_id")
	@NotNull(message = "account_id is mandatory")
	private Long accountId;

	@Column(name = "identity")
	private String identity;

	@Column(name = "name")
	private String name;

	@Column(name = "account")
	@NotNull(message = "account is mandatory")
	private String account;

	@Column(name = "password", nullable = true)
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "create_date")
	private Date createDate;

	public static Account of(String identity, String account) {

		return new Account(null, identity, null, account, null, null, null);

	}

}