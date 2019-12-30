package com.esys.datagen.datapopulation.main;

import com.esys.datagen.dataDefinition.bean.ColumnDefinition;
import com.esys.datagen.dataDefinition.bean.DataDefinitionBean;
import com.esys.datagen.datapopulation.populateDataSets.DataPopulationBean;
import com.esys.datagen.datapopulation.writer.OutPutWriter;

/**
 * 
 * This is the main hook point where the data generator can be triggered.
 * 
 * @Param ColumnDefinition(addColumn)
 * @Param rows(setRows)
 * @Api generateData() --populates a string with the required data, where the
 *      first line will be header
 * 
 */
public class DataPopulationMain {

	private DataDefinitionBean dataDefinitionBean;


	public DataPopulationMain() {

		dataDefinitionBean = new DataDefinitionBean();

	}

	public void addColumn(ColumnDefinition columnDefinition) {

		dataDefinitionBean.add(columnDefinition);

	}

	public void setRows(int row) {

		dataDefinitionBean.setRowSize(row);

	}
	/*public StringBuilder generateData() {

		
		// Testing purpose
		System.out.println(System.currentTimeMillis());
		newGenerateData();
		System.out.println(System.currentTimeMillis());
		System.out.println("Completed the new code");
		DataPopolationBean populationBean = new DataPopolationBean(dataDefinitionBean, rows);
		System.out.println(System.currentTimeMillis());
		OutPutWriter outPutWriter = new OutPutWriter(populationBean);

		return outPutWriter.write();

	}*/

	
	// New Populator
	
	public StringBuilder generateData() {
		DataPopulationBean populationBean = new DataPopulationBean(dataDefinitionBean);
		OutPutWriter outPutWriter = new OutPutWriter(populationBean);

		return outPutWriter.write();

	}

	
	
}
