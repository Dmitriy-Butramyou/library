package test.butramyou.library.services.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;
import test.butramyou.library.model.BooksCSVRecord;
import test.butramyou.library.model.BorrowedCSVRecord;
import test.butramyou.library.model.UserCSVRecord;
import test.butramyou.library.services.CsvService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CsvServiceImplTest {

    @Autowired
    CsvService csvService;

    @Test
    void convertUserCSV() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:csvdata/user.csv");
        List<UserCSVRecord> records = csvService.convertUserCSV(file);
        assertThat(records.size()).isEqualTo(11);
    }

    @Test
    void convertBooksCSV() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:csvdata/books.csv");
        List<BooksCSVRecord> records = csvService.convertBookCSV(file);
        assertThat(records.size()).isEqualTo(111);
    }

    @Test
    void convertBorrowedCSV() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:csvdata/borrowed.csv");
        List<BorrowedCSVRecord> records = csvService.convertBorrowedCSV(file);
        assertThat(records.size()).isEqualTo(118);
    }
}