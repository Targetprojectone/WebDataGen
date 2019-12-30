package com.esys.datagen.datapopulation.populateDataSets;

import java.text.SimpleDateFormat;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;
import com.github.javafaker.Faker;

public class PopulateTimeStampData extends PopulateDataHandler implements PopulateData  {
	

		public PopulateTimeStampData(ColumnDefinition definition, DataPopulator dataObject) {
			
			super(definition, dataObject);
			
		}

		@Override
		public void generateData() {

			if (isDomainValuePopulated()) {

				return;

			}
			
			//dataSet.setColumnName(getColumnDef().getColumnName());
			Faker faker = new Faker();

			int rows = getRows();
			
			  SimpleDateFormat formatter ;  
				if(getColumnDef().getDataType().equalsIgnoreCase("DATE")){
				formatter =new SimpleDateFormat("MM/dd/yyyy");
				for (int i = 0; i < rows; i++) {
					
					
					
					dataSet.add(formatter.format(faker.date().birthday()));
				} 
				}else if (getColumnDef().getDataType().equalsIgnoreCase("TIMESTAMP"))
				
				{
					formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");  
					for (int i = 0; i < rows; i++) {
						
						dataSet.add(formatter.format(faker.date().birthday()));
					} 
					
				}
				else{
					
					throwException("Enterd Column Data type: " + getColumnDef().getDataType() + " is not configured");
					
				}

				addDataSet();


			
			
			
			
			
		}


}
