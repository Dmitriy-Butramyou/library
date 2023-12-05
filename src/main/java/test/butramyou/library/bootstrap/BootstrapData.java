package test.butramyou.library.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import test.butramyou.library.entity.Book;
import test.butramyou.library.entity.Borrowed;
import test.butramyou.library.entity.User;
import test.butramyou.library.model.BooksCSVRecord;
import test.butramyou.library.model.BorrowedCSVRecord;
import test.butramyou.library.model.GenderType;
import test.butramyou.library.model.UserCSVRecord;
import test.butramyou.library.repositories.BookRepository;
import test.butramyou.library.repositories.BorrowedRepository;
import test.butramyou.library.repositories.UserRepository;
import test.butramyou.library.services.CsvService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final CsvService csvService;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BorrowedRepository borrowedRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadUserCsvData();
        loadBookCsvData();
        loadBorrowedCsvData();
    }

    private void loadUserCsvData() throws FileNotFoundException {
        if (userRepository.count() == 0) {
            File file = ResourceUtils.getFile("classpath:csvdata/user.csv");
            List<UserCSVRecord> userCSVRecords = csvService.convertUserCSV(file);

            userCSVRecords.forEach(userCSVRecord -> {
                GenderType genderType = switch (userCSVRecord.getGender()) {
                    case "f" -> GenderType.FEMALE;
                    case "m" -> GenderType.MALE;
                    default -> GenderType.NA;
                };

                userRepository.save(User.builder()
                        .firstName(userCSVRecord.getFirstName())
                        .surname(userCSVRecord.getSurname())
                        .gender(genderType)
                        .memberSince(userCSVRecord.getMemberSince())
                        .memberTill(userCSVRecord.getMemberTill())
                        .build());
            });
        }
    }

    private void loadBookCsvData() throws FileNotFoundException {
        if (bookRepository.count() == 0) {
            File file = ResourceUtils.getFile("classpath:csvdata/books.csv");
            List<BooksCSVRecord> booksCSVRecords = csvService.convertBookCSV(file);

            booksCSVRecords.forEach(booksCSVRecord -> {
                bookRepository.save(Book.builder()
                        .title(booksCSVRecord.getTitle())
                        .author(booksCSVRecord.getAuthor())
                        .genre(booksCSVRecord.getGenre())
                        .publisher(booksCSVRecord.getPublisher())
                        .build());
            });
        }
    }

    private void loadBorrowedCsvData() throws FileNotFoundException {
        if (borrowedRepository.count() == 0) {
            File file = ResourceUtils.getFile("classpath:csvdata/borrowed.csv");
            List<BorrowedCSVRecord> borrowedCSVRecords = csvService.convertBorrowedCSV(file);

            List<User> users = userRepository.findAll();
            List<Book> books = bookRepository.findAll();

            borrowedCSVRecords.forEach(borrowedCSVRecord -> {
                Book borrowedBook = books.stream().filter(book -> book.getTitle().equals(borrowedCSVRecord.getBookTitle()))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException(String.format("There is no book in the library with the title: %s", borrowedCSVRecord.getBookTitle())));

                String[] borrower = borrowedCSVRecord.getBorrower().split(",");

                User userBorrower = users.stream().filter(user -> user.getSurname().equals(borrower[0]) && user.getFirstName().equals(borrower[1]))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException(String.format("There is no user with name: %s", borrowedCSVRecord.getBorrower())));

                borrowedRepository.save(Borrowed.builder()
                        .book(borrowedBook)
                        .user(userBorrower)
                        .borrowDate(borrowedCSVRecord.getBorrowDate())
                        .returnDate(borrowedCSVRecord.getReturnDate())
                        .build());
            });
        }
    }
}
