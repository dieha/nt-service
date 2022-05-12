package com.redhat.lab.nt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.lab.nt.entity.GeneralRes;
import com.redhat.lab.nt.usecase.BankCodeService;

@RestController
@RequestMapping("/")
@CrossOrigin
public class BankCodeController {

	@Resource
	BankCodeService bankCodeService;

	@GetMapping("/bankCode")
	public GeneralRes index(HttpServletRequest reauest) {

		return new GeneralRes("200", "BankCode", bankCodeService.all());
	}

}
