package test.butramyou.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import test.butramyou.library.entity.Borrowed;

import java.util.UUID;

public interface BorrowedRepository extends JpaRepository<Borrowed, UUID> {
}
