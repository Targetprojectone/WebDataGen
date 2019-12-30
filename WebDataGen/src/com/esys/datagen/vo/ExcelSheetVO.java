package com.esys.datagen.vo;

public class ExcelSheetVO {
	private String sheetName;
	private String sheetDataStr = new String();
	private StringBuilder result = new StringBuilder();

	public StringBuilder getResult() {
		return result;
	}

	public void setResult(StringBuilder result) {
		this.result = result;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getSheetDataStr() {
		return sheetDataStr;
	}

	public void setSheetDataStr(String sheetDataStr) {
		this.sheetDataStr = sheetDataStr;
	}


}
