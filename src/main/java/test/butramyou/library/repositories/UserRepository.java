package test.butramyou.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.butramyou.library.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT DISTINCT u FROM User u JOIN u.borrowings b WHERE b.returnDate IS NOT NULL")
    List<User> getUsersWithBorrowedBooks();

    @Query("SELECT DISTINCT u FROM User u LEFT JOIN u.borrowings b WHERE u.memberTill < current date AND (b IS NULL OR b.returnDate < current date)")
    List<User> getNonTerminatedUsersWithNoCurrentBorrowings();
}
