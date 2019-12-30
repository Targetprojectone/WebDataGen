package com.esys.datagen.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.esys.datagen.vo.ExcelSheetVO;

//ColumnName,DataType,PreDefined,Nullable,PrimaryKey,Domain
public class ExcelReader {

	public List<ExcelSheetVO> readExcel(InputStream file) throws IOException, InvalidFormatException {
		Workbook workbook = WorkbookFactory.create(file);

		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		List<ExcelSheetVO> inputExcelSheetList = new ArrayList<ExcelSheetVO>();

		System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
		workbook.forEach(sheet -> inputExcelSheetList.add(processContent(sheet)));

		workbook.close();

		return inputExcelSheetList;
	}

	public ExcelSheetVO processContent(Sheet sheet) {

		DataFormatter dataFormatter = new DataFormatter();

		ExcelSheetVO sheetVO = new ExcelSheetVO();

		sheetVO.setSheetName(sheet.getSheetName());
		System.out.println("Processing => " + sheet.getSheetName());
		String sheetDataStr = "";
		for (Row row : sheet) {

			for (int i = 0; i < 6; i++) {
				Cell cell = row.getCell(i);
				// for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				sheetDataStr += (cellValue + ",");
			}
			sheetDataStr += "\n";
			System.out.println();
		}
		sheetVO.setSheetDataStr(sheetDataStr);
		return sheetVO;
	}
}
