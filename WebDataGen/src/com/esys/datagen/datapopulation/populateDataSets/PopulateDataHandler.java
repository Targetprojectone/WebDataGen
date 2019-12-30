package com.esys.datagen.datapopulation.populateDataSets;

import java.util.List;
import java.util.Random;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;
import com.esys.datagen.datapopulation.dataSets.DataSet;

public class PopulateDataHandler {

	private ColumnDefinition columnDef;
	private DataPopulator dataObject;
	private int rows;
	DataSet dataSet = new DataSet();
	public PopulateDataHandler(ColumnDefinition definition, DataPopulator dataObject) {
		this.columnDef = definition;
		this.dataObject = dataObject;
		this.rows = dataObject.getDataRowSize();
	}

	public ColumnDefinition getColumnDef() {
		return columnDef;
	}

	public void setColumnDef(ColumnDefinition columnDef) {
		this.columnDef = columnDef;
	}

	public void setDataObject(DataPopulator dataObject) {
		this.dataObject = dataObject;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean isDomainValuePopulated() {

		if (!getColumnDef().getDomainValues().isEmpty()) {
			Random rand = new Random();

			List<String> domainValues = getColumnDef().getDomainValues();

			for (int i = 0; i < rows; i++) {

				int randomIndex = rand.nextInt(domainValues.size());

				dataSet.add(domainValues.get(randomIndex));
			}

			addDataSet();

			return true;

		}

		return false;
	}

	public void addDataSet() {

		if (columnDef.isNullable()) {

			processNullable(dataSet);
		}

		dataObject.addDataSet(columnDef.getColumnName(),dataSet);

	}

	private void processNullable(DataSet dataSet) {

		List<String> setSize = dataSet.getDataSet();

		Random random = new Random();
		
		int nullCount = setSize.size()*30/100;
		
		for (int i = 0; i < nullCount; i++) {

			int nextInt = random.nextInt(setSize.size());
		
			setSize.set(nextInt, "null");

		}

	}

}
