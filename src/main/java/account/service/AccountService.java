package account.service;

import account.controller.form.AccountRequestForm;
import account.entitiy.MemberAcccount;

public interface AccountService {

    MemberAcccount register(AccountRequestForm accountRequestForm);
}

