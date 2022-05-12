package com.redhat.lab.nt.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redhat.lab.nt.entity.BankCode;


@Repository
public interface BankCodeDao extends JpaRepository<BankCode, String> {
}
