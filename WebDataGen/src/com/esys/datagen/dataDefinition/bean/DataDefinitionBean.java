package com.esys.datagen.dataDefinition.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class DataDefinitionBean {

	List<ColumnDefinition> defObj;
	
	int rowSize;

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public DataDefinitionBean() {

		defObj = new ArrayList<ColumnDefinition>();

	}

	public void add(ColumnDefinition definition) {

		defObj.add(definition);

	}

	public void addAll(Collection<? extends ColumnDefinition> paramCollection) {

		defObj.addAll(paramCollection);

	}
	public List<ColumnDefinition> getColumnDefinitions() {

	return defObj;
	}
	public String getHeader() {

		StringBuilder header = new StringBuilder();
		defObj.forEach(o -> header.append(o.getColumnName()).append(","));
	/*	if(header.length()!=0){
		header.deleteCharAt(header.length()-1);
		}*/
		return header.toString();
	}




}
