package test.butramyou.library.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.butramyou.library.entity.Book;
import test.butramyou.library.repositories.BookRepository;
import test.butramyou.library.services.BookService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
