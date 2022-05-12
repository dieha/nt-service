package com.redhat.lab.nt.usecase;

import java.util.List;

import com.redhat.lab.nt.entity.Account;
import com.redhat.lab.nt.entity.Deposit;
import com.redhat.lab.nt.entity.RecordQuery;
import com.redhat.lab.nt.entity.Transfer;

public interface NtService {

	public List<Deposit> balance(Account account);

	public Deposit balance(Deposit deposit);

	public Transfer tranfer(Transfer transfer);

	public List<Transfer> record(RecordQuery deposit);

	public Transfer tranferById(String id);
}
