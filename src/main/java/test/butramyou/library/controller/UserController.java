package test.butramyou.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.butramyou.library.entity.User;
import test.butramyou.library.services.UserService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = userService.getAllBooks();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/borrowed-books")
    public ResponseEntity<List<User>> getUsersWithBorrowedBooks() {
        List<User> users = userService.getUsersWithBorrowedBooks();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/non-terminated-no-borrowings")
    public ResponseEntity<List<User>> getNonTerminatedUsersWithNoCurrentBorrowings() {
        List<User> users = userService.getNonTerminatedUsersWithNoCurrentBorrowings();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<HttpStatus> getUserById(@PathVariable("userId") UUID userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<HttpStatus> updateUser(@PathVariable("userId") UUID userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> postUser(@RequestBody User user) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userId") UUID userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}