package com.esys.datagen.datapopulation.populateDataSets;

import com.esys.datagen.dataDefinition.bean.DataDefinitionBean;

public class DataPopulationBean extends DataPopulator{
	
	public DataPopulationBean(DataDefinitionBean dataDefinitionBean) {
		
		super(dataDefinitionBean);
		getGeneratedDataObject();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This will parallel process the generation of data sets for the given column definitions.
	 *
	 * @return the generated data object
	 */
	private void getGeneratedDataObject() {

	getDataDefinitionBean().getColumnDefinitions().parallelStream().forEach(
				columnDefinition -> new PopulateDataMapper(columnDefinition, getDataPopulator()));

		
/*
		getDataDefinitionBean().getColumnDefinitions(). forEach(
				columnDefinition -> new PopulateDataMapper(columnDefinition, getDataPopulator()));
		
		*/
	}
	
/*	private void generateDataSets(ColumnDefinition columnDefinition) {

		
		
		
	}*/
	

}
