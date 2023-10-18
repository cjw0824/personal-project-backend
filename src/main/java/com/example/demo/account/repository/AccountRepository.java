package com.example.demo.account.repository;

import com.example.demo.account.entity.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<MemberAccount, Long> {
    Optional<MemberAccount> findByEmail(String email);
}
