package com.amar.javastuff.ReadExcelData;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelDataService {

	public static final String SAMPLE_XLSX_FILE_PATH = "/home/amar/Downloads/EmpMaster.xlsx";
	
	public void readData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
		// Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });
        
        
        Sheet sheet = (Sheet) workbook.getSheetAt(1);
        
        DataFormatter dataFormatter = new DataFormatter();
        
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
	}
}
