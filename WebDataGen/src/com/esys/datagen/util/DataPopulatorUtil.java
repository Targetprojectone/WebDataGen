package com.esys.datagen.util;

import java.util.Arrays;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;
import com.esys.datagen.datapopulation.main.DataPopulationMain;

public class DataPopulatorUtil {

	public static StringBuilder populateDataBean(String ddlStr, int rowCount) {

		DataPopulationMain dataPopulatorObj = new DataPopulationMain();
		dataPopulatorObj.setRows(rowCount);
		String[] ddlLineArr = ddlStr.split("\n");
		int startLine=checkHasHeader(ddlLineArr[0]);
		ColumnDefinition columnDefinition;
		for (int i = startLine; i < ddlLineArr.length; i++) {
			String ddlLineStr = ddlLineArr[i];

			 columnDefinition= new ColumnDefinition();
			String[] ddlTokenArr = ddlLineStr.split(",");

			if (ddlTokenArr.length > 0)
				columnDefinition.setColumnName(ddlTokenArr[0].trim());
			if (ddlTokenArr.length > 1)
				columnDefinition.setDataType(ddlTokenArr[1].trim());
			if (ddlTokenArr.length > 2)
				columnDefinition.setPreDefinedValue(ddlTokenArr[2].trim());
			if (ddlTokenArr.length > 3)
				columnDefinition.setNullable(ddlTokenArr[3].trim());
			if (ddlTokenArr.length > 4)
				columnDefinition.setPrimarykey(ddlTokenArr[4].trim());
			if (ddlTokenArr.length > 5){// The code will consider all ',' values after 5th element as domain values
				String[] copyOfRange = Arrays.copyOfRange(ddlTokenArr,5,ddlTokenArr.length);
				columnDefinition.setDomainValues(copyOfRange);
			}
			dataPopulatorObj.addColumn(columnDefinition);
		}

		return dataPopulatorObj.generateData();
	}

	private static int checkHasHeader(String firstLine) {
	String upperCase =	firstLine.toUpperCase();

		if (upperCase.contains("COLUMNNAME") && upperCase.contains("DATATYPE")) {

			return 1;
		}
	
	return 0;
	}

}
