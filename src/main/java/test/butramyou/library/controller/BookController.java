package test.butramyou.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.butramyou.library.entity.Book;
import test.butramyou.library.services.BookService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/book")
@RestController
public class BookController {

    private final BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> listBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<HttpStatus> getBookById(@PathVariable("bookId") UUID bookId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<HttpStatus> updateBook(@PathVariable("bookId") UUID bookId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> postBook(@RequestBody Book book) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("bookId") UUID bookId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
