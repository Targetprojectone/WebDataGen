package com.esys.datagen.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esys.datagen.util.CSVReader;
import com.esys.datagen.util.DataPopulatorUtil;
import com.esys.datagen.util.ExcelReader;
import com.esys.datagen.util.ExcelWriter;
import com.esys.datagen.vo.ExcelSheetVO;

@Service
public class DataGenService {

	public List<ExcelSheetVO> processCsvInputFile(MultipartFile ddlFile, String fileName) {
		try {
			return new CSVReader().readCsv(ddlFile.getInputStream(), fileName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<ExcelSheetVO> processExcelInputFile(MultipartFile ddlFile) {
		try {
			return new ExcelReader().readExcel(ddlFile.getInputStream());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public StringBuilder processDdlDefs(String ddlDefStr, int numberOfRequiredRecords) {

		return DataPopulatorUtil.populateDataBean(ddlDefStr, numberOfRequiredRecords);
	}

	public byte[] getExcelOutAsByteStream(List<ExcelSheetVO> ddlDefLst){
		return new ExcelWriter().getExcelContent(ddlDefLst);
	}
	
	public ResponseEntity<InputStreamResource> getExcelAsHttpResponse(String fileName, byte[] excelContent) {
		if (excelContent.length != 0) {
			try {
				// String fileName = "DataGen.xlsx";
				MediaType mediaType = MediaType.parseMediaType("application/vnd.ms-excel");
				File file = new File("C:\\Sri Krishna\\Data Gen POC\\"+fileName);
				FileUtils.writeByteArrayToFile(file, excelContent);
				InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
						.contentType(mediaType).contentLength(file.length()).body(resource);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	public String getResponseFileName(String fileName){
		String dateSuffixStr = new SimpleDateFormat("'_generated_'yyMMddHHmmss").format(new Date());

		String[] nmArr = fileName.split("\\.");
		
		return nmArr[0] + dateSuffixStr + "."+nmArr[1];
	}
}