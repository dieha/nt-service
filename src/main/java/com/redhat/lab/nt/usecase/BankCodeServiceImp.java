package com.redhat.lab.nt.usecase;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.redhat.lab.nt.dao.BankCodeDao;
import com.redhat.lab.nt.entity.BankCode;

@Service
public class BankCodeServiceImp implements BankCodeService {

	@Resource
	BankCodeDao bankCodeDao;

	@Override
	public List<BankCode> all() {
		return bankCodeDao.findAll();
	}

}
