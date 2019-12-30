package com.esys.datagen.datapopulation.populateDataSets;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;
import com.github.javafaker.Faker;

public class PopulateVarcharData extends PopulateDataHandler implements PopulateData {

	protected PopulateVarcharData(ColumnDefinition definition, DataPopulator dataObject) {

		super(definition, dataObject);

	}

	@Override
	public void generateData() {

		int rows = getRows();

		if (isDomainValuePopulated()) {

			return;

		}
		//dataSet.setColumnName(getColumnDef().getColumnName());

		int size = 20;
		// default size is taken as 20

		try {

			String charSize = getColumnDef().getDataType().replaceAll("[^0-9]", "");

			size = !charSize.isEmpty() ? Integer.parseInt(charSize) : size;

			Faker faker = new Faker();

			for (int i = 0; i < rows; i++) {

				dataSet.add(faker.lorem().fixedString(size));

			}

			addDataSet();

		} catch (Exception e) {

			throwException("Enterd Column Data type: " + getColumnDef().getDataType() + "  is Invalid type");
		}

	}

}
