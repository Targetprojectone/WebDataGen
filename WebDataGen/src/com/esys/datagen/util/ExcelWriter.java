package com.esys.datagen.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.esys.datagen.vo.ExcelSheetVO;

public class ExcelWriter {

	public byte[] getExcelContent(List<ExcelSheetVO> ddlDefLst) {

		Workbook workbook = new XSSFWorkbook();

		for (ExcelSheetVO excelSheetVO : ddlDefLst) {

			Sheet sheet = workbook.createSheet(excelSheetVO.getSheetName());

			String[] strLineArr = excelSheetVO.getResult().toString().split("\n");

			List<String> columnNames = new ArrayList<String>();
			String[] columnNameStrArr = strLineArr[0].split(",");
			for (String colName : columnNameStrArr) {
				columnNames.add(colName);
			}

			List<String> dataValLst = new ArrayList<String>();
			for (int i = 1; i < strLineArr.length; i++) {
				dataValLst.add(strLineArr[i]);
			}

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

			int rowNum = 1;
			for (String data : dataValLst) {
				String[] obj = data.split(",");
				Row row = sheet.createRow(rowNum++);

				for (int i = 0; i < columnNames.size(); i++) {

					if (!obj[i].trim().equals(""))
						row.createCell(i).setCellValue(obj[i]);
				}
			}
			// Resize all columns to fit the content size
			for (int i = 0; i < columnNames.size(); i++) {
				sheet.autoSizeColumn(i);
			}

		}

		ByteArrayOutputStream fileOut;
		byte[] byteArr = null;
		try {
			fileOut = new ByteArrayOutputStream();
			workbook.write(fileOut);
			byteArr = fileOut.toByteArray();
			workbook.close();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArr;
	}
}
