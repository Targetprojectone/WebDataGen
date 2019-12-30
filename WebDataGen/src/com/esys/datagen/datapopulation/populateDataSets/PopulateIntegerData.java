package com.esys.datagen.datapopulation.populateDataSets;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;
import com.github.javafaker.Faker;

public class PopulateIntegerData extends PopulateDataHandler implements PopulateData  {

	
	

	public PopulateIntegerData(ColumnDefinition definition, DataPopulator dataObject) {
		
		super(definition, dataObject);
		
	}

	@Override
	public void generateData() {
		
		if (isDomainValuePopulated()) {

			return;

		}
		//Checks whether the key is unique
		boolean isUnique = getColumnDef().isPrimarykey();
		
		Faker faker = new Faker();

		int rows = getRows();
		
		if (getColumnDef().getDataType().equalsIgnoreCase("INTEGER")) {

			for (int i = 0; i < rows; i++) {

				dataSet.add(Long.toString(faker.number().numberBetween(0, Integer.MAX_VALUE)));
			}
		}
		else if (getColumnDef().getDataType().equalsIgnoreCase("BIGINT"))
		{

			for (int i = 0; i < rows; i++) {

				dataSet.add(Long.toString(faker.number().randomNumber(16, isUnique)));
			}

		}
		else {

			throwException("Enterd Column Data type: " + getColumnDef().getDataType() + " is not configured");

		}

			addDataSet();


		
		}
}
