package com.esys.datagen.datapopulation.populateDataSets;

import com.esys.datagen.dataDefinition.bean.DataDefinitionBean;
import com.esys.datagen.datapopulation.dataSets.DataObject;
import com.esys.datagen.datapopulation.dataSets.DataSet;

public class DataPopulator {

	private DataObject dataObject;

	private DataDefinitionBean dataDefinitionBean;

	public DataDefinitionBean getDataDefinitionBean() {
		return dataDefinitionBean;
	}

	public void setDataDefinitionBean(DataDefinitionBean dataDefinitionBean) {
		this.dataDefinitionBean = dataDefinitionBean;
	}

	public DataPopulator(DataDefinitionBean dataDefinitionBean) {

		dataObject = new DataObject();
		this.dataDefinitionBean = dataDefinitionBean;
	}

	public synchronized void addDataSet(String columnName,DataSet dataSet) {
		dataObject.add(columnName,dataSet);
	}

	public DataObject getDataObject() {

		return dataObject;

	}

	public DataPopulator getDataPopulator() {

		return this;

	}

	public int getDataRowSize() {

		return dataDefinitionBean.getRowSize();

	}

	public String getHeader() {

		return dataDefinitionBean.getHeader();

	}

	
	
}
