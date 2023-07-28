package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountLoginResponseForm;
import com.example.demo.account.controller.form.AccountRequestForm;
import com.example.demo.account.entity.MemberAccount;
import com.example.demo.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static java.awt.SystemColor.window;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    final private AccountRepository accountRepository;

    @Override
    public void register(AccountRequestForm accountRequestForm) {
        //등록된 emaill인지 확인
        // emaill 찾은 계정
        final Optional<MemberAccount> maybeAccount
                = accountRepository.findByEmail(accountRequestForm.getEmail());
        if(maybeAccount.isEmpty()){
            accountRepository.save(accountRequestForm.toMemberAccount());
        }
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

    @Override
    public AccountLoginResponseForm login(AccountRequestForm accountRequestForm) {
        //email로 찾은 계정
        final Optional<MemberAccount> maybeAccount
                = accountRepository.findByEmail(accountRequestForm.getEmail());
        //email이 존재하지 않으면
        //UUID null
//        if (maybeAccount.isEmpty()) {
//            log.info("[로그인 실패] 가입되지 않은 이메일 입니다.");
//            return new AccountLoginResponseForm(null);
//        }
        //email로 찾은 계정의 비밀번호와, 입력받은 폼의 비밀번호가 일치하면...
        //UUID 생성
        if (maybeAccount.get().getPassword().equals(accountRequestForm.getPassword())) {
            log.info("[로그인 성공]");
            UUID uuid = UUID.randomUUID();
            String userEmail = maybeAccount.get().getEmail();
            System.out.println("New randomUUID: " + uuid.toString());
            System.out.println("userEmail: " + userEmail);
            return new AccountLoginResponseForm(uuid, userEmail);
        } else {
            log.info("[로그인 실패] 비밀번호가 일치하지 않습니다.");
            return null;
        }
    }

//    @Override
//    public AccountLoginResponseForm login(AccountRequestForm accountRequestForm) {
//        //email로 찾은 계정
//        final Optional<MemberAccount> maybeAccount
//                = accountRepository.findByEmail(accountRequestForm.getEmail());
//
//        //email이 존재하지 않으면
//        if (maybeAccount.isEmpty()) {
//            log.info("[로그인 실패] 가입되지 않은 이메일 입니다.");
//            return new AccountLoginResponseForm(null);
//        }
//        //email로 찾은 계정의 비밀번호와, 입력받은 폼의 비밀번호가 일치하면...
//        if (maybeAccount.get().getPassword().equals(accountRequestForm.getPassword())) {
//            log.info("[로그인 성공]");
//            return new AccountLoginResponseForm(UUID.randomUUID());
//        } else {
//            log.info("[로그인 실패] 비밀번호가 일치하지 않습니다.");
//            return new AccountLoginResponseForm(null);
//        }
//    }


}
