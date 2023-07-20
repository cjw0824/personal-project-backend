package account.controller.form;

import account.entitiy.MemberAcccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRequestForm {

    final private String email;
    final private String password;

    public MemberAcccount toMemberAcccount() {
        return new MemberAcccount(email, password);
    }

}
