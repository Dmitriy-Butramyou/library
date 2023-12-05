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
public class UserCSVRecord {

    @CsvBindByName(column = "Name", required = true)
    private String surname;
    @CsvBindByName(column = "First name", required = true)
    private String firstName;
    @CsvDate(value = "MM/dd/yyyy")
    @CsvBindByName(column = "Member since")
    private LocalDate memberSince;
    @CsvDate(value = "MM/dd/yyyy")
    @CsvBindByName(column = "Member till")
    private LocalDate memberTill;
    @CsvBindByName(column = "Gender")
    private String gender;
}