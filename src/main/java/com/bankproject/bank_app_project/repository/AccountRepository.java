package com.bankproject.bank_app_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankproject.bank_app_project.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
