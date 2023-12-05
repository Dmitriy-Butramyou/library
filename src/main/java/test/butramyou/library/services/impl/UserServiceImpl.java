package test.butramyou.library.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.butramyou.library.entity.User;
import test.butramyou.library.repositories.UserRepository;
import test.butramyou.library.services.UserService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllBooks() {
        return userRepository.findAll();
    }
}
