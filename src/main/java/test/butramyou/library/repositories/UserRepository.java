package test.butramyou.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import test.butramyou.library.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
