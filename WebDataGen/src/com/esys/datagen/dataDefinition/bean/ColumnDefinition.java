package com.esys.datagen.dataDefinition.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnDefinition {

	private String columnName;

	private String dataType;

	private String preDefinedValue;

	private boolean nullable;

	private boolean primarykey;

	private String[] domainValues;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getPreDefinedValue() {
		return preDefinedValue == null ? "" : preDefinedValue;
	}

	public void setPreDefinedValue(String preDefinedValue) {
		this.preDefinedValue = preDefinedValue;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {

		this.nullable = nullable != null && (nullable.equalsIgnoreCase("TRUE") || nullable.equalsIgnoreCase("YES"));

	}

	public boolean isPrimarykey() {
		return primarykey;
	}

	public void setPrimarykey(String prmKey) {

		this.primarykey = prmKey != null && (prmKey.equalsIgnoreCase("TRUE") || prmKey.equalsIgnoreCase("YES"));

	}

	public List<String> getDomainValues() {
		if (this.domainValues == null) {
			return new ArrayList<String>();
		}
		return Arrays.asList(domainValues);
	}

	public void setDomainValues(String[] domainValues) {
		this.domainValues = domainValues;
	}

}
