package org.maples.gem.admin.utility;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelUtils {
    public static List<List<String>> load(InputStream inputStream, int sheetIndex) {
        List<List<String>> result = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(inputStream)){
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            DataFormatter dataFormatter = new DataFormatter();

            for (Row row : sheet) {
                List<String> temp = new ArrayList<>();
                for (Cell cell : row) {
                    temp.add(dataFormatter.formatCellValue(cell).trim());
                }
                result.add(temp);
            }
        } catch (IOException e) {
            log.warn(e.getLocalizedMessage());
        }

        return result;
    }

    public static void dump(List<List<Object>> values, OutputStream outputStream) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        int currentRowIndex = 0;
        for (List<Object> rowValues : values) {
            Row row = sheet.createRow(currentRowIndex++);
            int currentCellIndex = 0;
            for (Object value : rowValues) {
                Cell cell = row.createCell(currentCellIndex++);

                if (value instanceof Integer) {
                    cell.setCellValue((Integer) value);
                } else if (value instanceof Double) {
                    cell.setCellValue((Double) value);
                } else {
                    cell.setCellValue((String) value);
                }
            }
        }

        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
