package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
public class ExcelUtils {
    static String excelFilePath = "src/test/java/ExcelTools/Login Information.xlsx";

    public static Person getUserInformation() throws IOException {
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Person person = null;
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; //hearders
            {
                person = new Person(row.getCell(0).toString(), row.getCell(1).toString());
            }
        }
        workbook.close();
        return person;
    }
}
