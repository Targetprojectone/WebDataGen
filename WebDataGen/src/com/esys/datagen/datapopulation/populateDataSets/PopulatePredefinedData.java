package com.esys.datagen.datapopulation.populateDataSets;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;
import com.github.javafaker.Faker;

public class PopulatePredefinedData extends PopulateDataHandler implements PopulateData {

	public PopulatePredefinedData(ColumnDefinition definition, DataPopulator dataObject) {
		
		super(definition, dataObject);
		
	}

	@Override
	public void generateData() {
		if (isDomainValuePopulated()) {

			return;

		}

		Faker faker = new Faker();

		ColumnDefinition columnDef = getColumnDef();
		
		//dataSet.setColumnName(columnDef.getColumnName());
		
		int rows = getRows();
		if (columnDef.getPreDefinedValue().equalsIgnoreCase("firstName")) {
			int i = 0;
			while (i < rows) {
				dataSet.add(faker.name().firstName());
				i++;
			}
		} else if (columnDef.getPreDefinedValue().equalsIgnoreCase("lastName")) {
			int i = 0;
			while (i < rows) {
				dataSet.add(faker.name().lastName());
				i++;
			}
		}

		else if (columnDef.getPreDefinedValue().equalsIgnoreCase("phonenumber")) {
			int i = 0;
			while (i < rows) {

				dataSet.add(faker.phoneNumber().cellPhone());
				i++;
			}

		} else {
			
			throwException("Enterd predefined type: " + columnDef.getPreDefinedValue() + " is not configured");

		}

		addDataSet();

	}

}
