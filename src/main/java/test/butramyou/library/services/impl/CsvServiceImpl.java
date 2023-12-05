package test.butramyou.library.services.impl;

import org.springframework.stereotype.Service;
import test.butramyou.library.model.BooksCSVRecord;
import test.butramyou.library.model.BorrowedCSVRecord;
import test.butramyou.library.model.UserCSVRecord;
import test.butramyou.library.services.CsvService;
import test.butramyou.library.util.CSVFileConverter;

import java.io.File;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService {

    @Override
    public List<UserCSVRecord> convertUserCSV(File csvFile) {
        CSVFileConverter<UserCSVRecord> userCSVConverter = new CSVFileConverter<>();
        return userCSVConverter.convertCSV(csvFile, UserCSVRecord.class);
    }

    @Override
    public List<BooksCSVRecord> convertBookCSV(File csvFile) {
        CSVFileConverter<BooksCSVRecord> userCSVConverter = new CSVFileConverter<>();
        return userCSVConverter.convertCSV(csvFile, BooksCSVRecord.class);
    }

    @Override
    public List<BorrowedCSVRecord> convertBorrowedCSV(File csvFile) {
        CSVFileConverter<BorrowedCSVRecord> userCSVConverter = new CSVFileConverter<>();
        return userCSVConverter.convertCSV(csvFile, BorrowedCSVRecord.class);
    }
}
