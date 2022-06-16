package com.nhnacademy.account.project.accountapi.repo;

import com.nhnacademy.account.project.accountapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


}
