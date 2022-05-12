package com.redhat.lab.nt.usecase;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.redhat.lab.nt.dao.DepositDao;
import com.redhat.lab.nt.dao.TransferDao;
import com.redhat.lab.nt.entity.Account;
import com.redhat.lab.nt.entity.Deposit;
import com.redhat.lab.nt.entity.RecordQuery;
import com.redhat.lab.nt.entity.Transfer;

@Service
public class NtServiceImp implements NtService {

	@Resource
	DepositDao depositDao;
	@Resource
	TransferDao transferDao;

	public List<Deposit> balance(Account account) {

		List<Deposit> list = depositDao.findAll(Example.of(new Deposit(null, account.getAccountId(), null, null)));

		return list;
	}

	public Deposit balance(Deposit deposit) {
		Optional<Deposit> op = depositDao.findById(deposit.getAccountNo());

		return op.get();
	}

	public Transfer tranfer(Transfer transfer) {

		Optional<Deposit> from = depositDao.findById(transfer.getFormAccountNo());
		if (from.isPresent()) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			
			transfer.setStatus("ok");
			transfer.setTransferDate( Timestamp.valueOf(LocalDateTime.parse(transfer.getTransferDateS(), formatter)));
			transfer.setCreateDate(new Timestamp(System.currentTimeMillis()));
			transfer = transferDao.save(transfer);

			Deposit deposit = from.get();
			deposit.setAmount(deposit.getAmount().subtract(transfer.getAmount()));
			depositDao.save(deposit);

		}
		if ("050".equals(transfer.getToBankCode())) {
			Optional<Deposit> too = depositDao.findById(transfer.getToAccountNo());
			Deposit deposit = from.get();
			deposit.setAmount(deposit.getAmount().add(transfer.getAmount()));
			depositDao.save(deposit);
		}

		return transfer;
	}

	public List<Transfer> record(RecordQuery record) {
		String accountNo = record.getAccountNo();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		

		List<Transfer> list = transferDao.findByFormAccountNoOrToAccountNoAndTransferDateBetween(accountNo, accountNo,
				 Timestamp.valueOf(LocalDateTime.parse(record.getStartDate(), formatter)),
				 Timestamp.valueOf(LocalDateTime.parse(record.getEndDate(), formatter)));
		
		list.stream().forEach(transfer -> {
			transfer.setTransferDateS(transfer.getTransferDate().toLocalDateTime().format(formatter));
			});
		
		return list;
	}

	public Transfer tranferById(String id) {

		Optional<Transfer> o = transferDao.findById(id);
		if (o.isPresent()) {
			Transfer transfer=o.get();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			transfer.setTransferDateS(transfer.getTransferDate().toLocalDateTime().format(formatter));
			return transfer;

		}

		return null;
	}
}
