package com.esys.datagen.datapopulation.populateDataSets;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;

public class PopulateDataMapper {
	
	

	public PopulateDataMapper(ColumnDefinition columnDefinition, DataPopulator dataObject) {
		populatDataAction(columnDefinition, dataObject);
	
	}
	
	
	/**
	 * This method points to the type of dataset populator implementation class
	 * 
	 * 
	 * */
	private void populatDataAction(ColumnDefinition columnDefinition, DataPopulator dataObject) {

		if(!columnDefinition.getPreDefinedValue().isEmpty()){
			
			 new PopulatePredefinedData(columnDefinition, dataObject).generateData();;
		}
		
		else if(columnDefinition.getDataType().toUpperCase().contains("VARCHAR")){
			
			 new PopulateVarcharData(columnDefinition, dataObject).generateData();;
		}
	
		else if(columnDefinition.getDataType().equalsIgnoreCase("BIGINT")||columnDefinition.getDataType().equalsIgnoreCase("INTEGER")){
			
			 new PopulateIntegerData(columnDefinition, dataObject).generateData();;
		}
		else if(columnDefinition.getDataType().equalsIgnoreCase("DATE")||columnDefinition.getDataType().equalsIgnoreCase("TIMESTAMP")){
			
			 new PopulateTimeStampData(columnDefinition, dataObject).generateData();
		}
		// Needs to throw Exception 
	}

}
