package com.esys.datagen.datapopulation.writer;

import com.esys.datagen.datapopulation.populateDataSets.DataPopulationBean;

public class OutPutWriter extends OutWriterObject {

	public OutPutWriter(DataPopulationBean populationBean) {

		super(populationBean);

	}

	/**
	 * This method prepares a stringBuilder by traversing all the generated
	 * dataSets
	 */
	public StringBuilder write() {

		StringBuilder builderObject = new StringBuilder();

		prepareDataObj(builderObject);

		// System.out.println(builderObject);

		return builderObject;

	}

}
