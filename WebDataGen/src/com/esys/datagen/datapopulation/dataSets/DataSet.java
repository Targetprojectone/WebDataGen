package com.esys.datagen.datapopulation.dataSets;

import java.util.ArrayList;
import java.util.List;

public class DataSet {

	private List<String> dataSet = new ArrayList<>();
	

	public List<String> getDataSet() {
		return dataSet;
	}

	public void add(String element) {
		dataSet.add(element);
	}
	public String getElementAt(int i) {
		return dataSet.get(i);
	}
}
