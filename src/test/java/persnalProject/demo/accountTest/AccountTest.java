package persnalProject.demo.accountTest;

import account.controller.form.AccountRequestForm;
import account.entitiy.MemberAcccount;
import account.service.AccountService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountTest {
    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("테스트 회원가입")
    void 테스트_회원가입 () {
        final String email = "test1@test.com";
        final String password = "test";

        AccountRequestForm accountRequestForm = new AccountRequestForm(email, password);
        accountService.register(accountRequestForm);
    }
}
