package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) throws IOException {
//Creating a workbook
        XSSFWorkbook workbook = workbook(Constant.EXCEL_FILE);
        XSSFSheet sheet = excelSheet(workbook, 0);
        Row row = excelRow(sheet, 0);
        Cell cell = excelCell(row, 0);
        System.out.println(sheet.getRow(0).getCell(0));
        Row row1 = sheet.getRow(1);
        Cell cell1 = row1.getCell(1);
        System.out.println(sheet.getRow(0).getCell(1));
        Row row2 = sheet.getRow(1);
        Cell cell2 = row2.getCell(1);
        System.out.println(sheet.getRow(1).getCell(0));
        Row row3 = sheet.getRow(1);
        Cell cell3 = row3.getCell(1);
        System.out.println(sheet.getRow(1).getCell(1));
        String cellval = cell.getStringCellValue();
        System.out.println(cellval);
    }

    public static XSSFWorkbook workbook(String filename) {
        XSSFWorkbook workbook = null;
        try {
            FileInputStream fs = new FileInputStream(filename);
            workbook = new XSSFWorkbook(fs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return workbook;
    }

    public static XSSFSheet excelSheet(XSSFWorkbook workbook, int index) {
        return workbook.getSheetAt(index);
    }

    public static Row excelRow(XSSFSheet sheet, int index) {
        return sheet.getRow(index);
    }

    public static Cell excelCell(Row row, int index) {
        return row.getCell(index);
    }
}
