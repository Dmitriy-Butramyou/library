package test.butramyou.library.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowedCSVRecord {

    @CsvBindByName(column = "Borrower", required = true)
    private String borrower;
    @CsvBindByName(column = "Book", required = true)
    private String bookTitle;
    @CsvDate(value = "MM/dd/yyyy")
    @CsvBindByName(column = "borrowed from")
    private LocalDate borrowDate;
    @CsvDate(value = "MM/dd/yyyy")
    @CsvBindByName(column = "borrowed to")
    private LocalDate returnDate;
}