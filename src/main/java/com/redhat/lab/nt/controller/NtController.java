package com.redhat.lab.nt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.lab.nt.entity.Account;
import com.redhat.lab.nt.entity.Deposit;
import com.redhat.lab.nt.entity.GeneralRes;
import com.redhat.lab.nt.entity.RecordQuery;
import com.redhat.lab.nt.entity.Transfer;
import com.redhat.lab.nt.usecase.NtService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/nt")
@Log4j2
@CrossOrigin
public class NtController {

	@Resource
	NtService ntService;

	@PostMapping("/balance")
	public GeneralRes balance(HttpServletRequest reauest, @Valid @RequestBody Account account) {

		try {

			List<Deposit> list = ntService.balance(account);

			return new GeneralRes("200", "", list);
		} catch (Exception e) {
			log.error("error", e);
		}
		return new GeneralRes("500", "", null);
	}

	@PostMapping("/tranfer")
	public GeneralRes tranfer(HttpServletRequest reauest, @Valid @RequestBody Transfer transfer) {

		try {
			transfer = ntService.tranfer(transfer);

			return new GeneralRes("200", "", transfer);
		} catch (Exception e) {
			log.error("error", e);
		}
		return new GeneralRes("500", "", null);
	}

	@PostMapping("/traded/record")
	public GeneralRes record(HttpServletRequest reauest, @Valid @RequestBody RecordQuery deposit) {

		try {
			List<Transfer> list = ntService.record(deposit);

			return new GeneralRes("200", "", list);
		} catch (Exception e) {
			log.error("error", e);
		}
		return new GeneralRes("500", "", null);
	}
	
	@GetMapping("/tranfer/{id}")
	public GeneralRes tranferByid(HttpServletRequest reauest,@PathVariable("id") String tranferId) {

		try {
			Transfer tranfer = ntService.tranferById(tranferId);

			return new GeneralRes("200", "", tranfer);
		} catch (Exception e) {
			log.error("error", e);
		}
		return new GeneralRes("500", "", null);
	}

}
