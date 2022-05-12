package com.redhat.lab.nt.dao;

import java.sql.Timestamp;
import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redhat.lab.nt.entity.Transfer;


@Repository
public interface TransferDao extends JpaRepository<Transfer, String> {
	
	List<Transfer> findByFormAccountNoOrToAccountNoAndTransferDateBetween(String formAccountNo,String toAccountNo,Timestamp startDate,Timestamp endDate);
}
