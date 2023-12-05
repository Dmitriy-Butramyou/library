package test.butramyou.library.util;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVFileConverter<T> {
    public List<T> convertCSV(File csvFile, Class<T> recordClass) {
        try {
            return new CsvToBeanBuilder<T>(new FileReader(csvFile))
                    .withType(recordClass)
                    .withIgnoreEmptyLine(true)
                    .withThrowExceptions(false)
                    .build().parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}