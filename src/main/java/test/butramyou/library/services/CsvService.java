package test.butramyou.library.services;

import test.butramyou.library.model.BooksCSVRecord;
import test.butramyou.library.model.BorrowedCSVRecord;
import test.butramyou.library.model.UserCSVRecord;

import java.io.File;
import java.util.List;

public interface CsvService {

    List<UserCSVRecord> convertUserCSV(File csvFile);
    List<BooksCSVRecord> convertBookCSV(File csvFile);
    List<BorrowedCSVRecord> convertBorrowedCSV(File csvFile);
}