package com.esys.datagen.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ControllerUtil {
	public ResponseEntity<InputStreamResource> getExcelAsHttpResponse(String fileName, byte[] excelContent) {
		if (excelContent.length != 0) {
			try {
				// String fileName = "DataGen.xlsx";
				MediaType mediaType = MediaType.parseMediaType("application/vnd.ms-excel");
				File file = new File(fileName);
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
