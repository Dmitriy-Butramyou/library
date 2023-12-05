package test.butramyou.library.services;

import test.butramyou.library.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllBooks();

    List<User> getUsersWithBorrowedBooks();

    List<User> getNonTerminatedUsersWithNoCurrentBorrowings();
}
