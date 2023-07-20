package account.service;

import account.controller.form.AccountRequestForm;
import account.entitiy.MemberAcccount;
import account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    final private AccountRepository accountRepository;

    @Override
    public MemberAcccount register(AccountRequestForm accountRequestForm) {
        MemberAcccount memberAcccount = new MemberAcccount(accountRequestForm.getEmail(), accountRequestForm.getPassword());
        return accountRepository.save(memberAcccount);
    }
}
