package com.esys.datagen.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.esys.datagen.vo.ExcelSheetVO;

public class CSVReader {
	public List<ExcelSheetVO> readCsv(InputStream inputStream, String fileName)
			throws IOException, InvalidFormatException {
		StringBuilder textBuilder = new StringBuilder();
		try (Reader reader = new BufferedReader(
				new InputStreamReader(inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
			int c = 0;
			while ((c = reader.read()) != -1) {
				textBuilder.append((char) c);
			}
		}

		System.out.println(textBuilder);
		
		List<ExcelSheetVO> inputSheetList = new ArrayList<ExcelSheetVO>();
		ExcelSheetVO inputDdl = new ExcelSheetVO();
		inputDdl.setSheetName(fileName);
		inputDdl.setSheetDataStr(textBuilder.toString());
		inputSheetList.add(inputDdl);

		return inputSheetList;
	}
}
