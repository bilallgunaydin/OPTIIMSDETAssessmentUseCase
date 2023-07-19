package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    static String excelFilePath = "src/test/java/ExcelTools/Login Information.xlsx";

    public static Person getUserInformation() throws IOException {
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Person person = null;
        //Cell Cell_UserName = null;
        //Cell Cell_Password = null;
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; //hearders
            {
                person = new Person(row.getCell(0).toString(), row.getCell(1).toString());
                //Cell_UserName = row.getCell(0);
                //Cell_Password = row.getCell(1);
            }
        }
        workbook.close();
        return person;
    }
}
