package account.repository;

import account.entitiy.MemberAcccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<MemberAcccount, Long> {
}
