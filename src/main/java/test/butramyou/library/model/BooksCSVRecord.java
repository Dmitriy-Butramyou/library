package test.butramyou.library.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksCSVRecord {

    @CsvBindByName(column = "Title", required = true)
    private String title;
    @CsvBindByName(column = "Author", required = true)
    private String author;
    @CsvBindByName(column = "Genre")
    private String genre;
    @CsvBindByName(column = "Publisher")
    private String publisher;
}