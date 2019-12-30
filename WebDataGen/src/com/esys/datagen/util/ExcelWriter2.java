package com.esys.datagen.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter2 {

	public byte[] getExcelContent(StringBuilder resultStr) throws IOException {
		Workbook workbook = new XSSFWorkbook();

		String[] strLineArr = resultStr.toString().split("\n");

		List<String> columnNames = new ArrayList<String>();
		String[] columnNameStrArr = strLineArr[0].split(",");
		for (String colName : columnNameStrArr) {
			columnNames.add(colName);
		}

		List<String> dataValLst = new ArrayList<String>();
		for (int i = 1; i < strLineArr.length; i++) {
			dataValLst.add(strLineArr[i]);
		}

		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("Sample Data");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columnNames.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columnNames.get(i));
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		int rowNum = 1;
		for (String data : dataValLst) {
			String[] obj = data.split(",");
			Row row = sheet.createRow(rowNum++);

			for (int i = 0; i < columnNames.size(); i++) {

				if (!obj[i].trim().equals(""))
					row.createCell(i).setCellValue(obj[i]);

				/*
				 * Cell dateOfBirthCell = row.createCell(2);
				 * dateOfBirthCell.setCellValue(getDateOfBirth());
				 * dateOfBirthCell.setCellStyle(dateCellStyle);
				 */

			}
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columnNames.size(); i++) {
			sheet.autoSizeColumn(i);
		}

		ByteArrayOutputStream fileOut;
		byte[] byteArr = null;
		try {
			fileOut = new ByteArrayOutputStream();
			workbook.write(fileOut);
			byteArr = fileOut.toByteArray();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		return byteArr;
	}	
}
