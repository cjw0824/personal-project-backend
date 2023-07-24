package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountRequestForm;
import com.example.demo.account.entitiy.MemberAccount;
import com.example.demo.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    final private AccountRepository accountRepository;

    @Override
    public MemberAccount register(AccountRequestForm accountRequestForm) {
        return accountRepository.save(accountRequestForm.toMemberAccount());
    }

    @Override
    public void delete(AccountRequestForm accountRequestForm) {
        //email로 찾은 계정
        final Optional<MemberAccount> maybeAccount
                = accountRepository.findByEmail(accountRequestForm.getEmail());
        MemberAccount memberAccount = maybeAccount.get();
        //email로 찾은 계정의 id
        Long id = memberAccount.getId();

        //email로 찾은 계정의 비밀번호와, 입력받은 폼의 비밀번호가 일치하면...
        if(memberAccount.getPassword().equals(accountRequestForm.getPassword())){
            accountRepository.deleteById(id);
        }
    }
}
