package com.esys.datagen.datapopulation.populateDataSets;



@FunctionalInterface
public interface PopulateData {
	
	
	
	void generateData();
	
	default Throwable throwException(String str){
		
		// Write the exception String
		return new Throwable(str);
		
		
		
	}
	

	
}
