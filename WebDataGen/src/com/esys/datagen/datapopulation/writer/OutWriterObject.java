package com.esys.datagen.datapopulation.writer;

import java.util.ArrayList;
import java.util.List;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;
import com.esys.datagen.dataDefinition.bean.DataDefinitionBean;
import com.esys.datagen.datapopulation.dataSets.DataSet;
import com.esys.datagen.datapopulation.populateDataSets.DataPopulationBean;
import com.esys.datagen.datapopulation.populateDataSets.DataPopulator;

public class OutWriterObject {

	DataPopulationBean dataBean;

	public OutWriterObject(DataPopulationBean populationBean) {

		this.dataBean = populationBean;

	}

	public void prepareDataObj(StringBuilder builderObject) {

		builderObject.append(dataBean.getDataDefinitionBean().getHeader());

		prepareData(builderObject);
	}

	private void prepareData(StringBuilder builderObject) {

		prepareRowData(builderObject, dataBean.getDataPopulator());

	}

	private void prepareRowData(StringBuilder builderObject, DataPopulator dataPopulator) {

		int rowSize = dataBean.getDataRowSize();
		DataDefinitionBean dataDefinitionBean = dataPopulator.getDataDefinitionBean();

		int row = 0;

		while (row < rowSize) {

			builderObject.append("\n");
			List<DataSet> dataSetList = getOderedSets(dataPopulator, dataDefinitionBean);
			for (DataSet dataSet : dataSetList) {
				builderObject.append(dataSet.getElementAt(row) + ",");
			}

			row++;
		}
	}

	private List<DataSet> getOderedSets(DataPopulator dataPopulator, DataDefinitionBean dataDefinitionBean) {

		List<DataSet> dataSetList = new ArrayList<DataSet>();

		for (ColumnDefinition columnDdef : dataDefinitionBean.getColumnDefinitions()) {
			DataSet dataSet = dataPopulator.getDataObject().getDataObject(columnDdef);
			dataSetList.add(dataSet);

		}
		return dataSetList;
	}

}
