package com.esys.datagen.datapopulation.dataSets;

import java.util.HashMap;
import java.util.Map;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;

public class DataObject {

	private Map<String,DataSet> dataObject = new HashMap<>();
	
	

	public void add(String colunName, DataSet dataSet) {
		dataObject.put(colunName,dataSet);
	}

	public Map<String,DataSet> getDataObject() {
		return dataObject;
	}

	

	public DataSet getDataObject(ColumnDefinition columnDefinition) {

		return dataObject.get(columnDefinition.getColumnName());

	}
}
