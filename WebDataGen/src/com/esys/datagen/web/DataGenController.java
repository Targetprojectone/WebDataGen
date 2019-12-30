package com.esys.datagen.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.esys.datagen.service.DataGenService;
import com.esys.datagen.vo.ExcelSheetVO;

@Controller
public class DataGenController {

	private final DataGenService dataGenService;

	@Autowired
	public DataGenController(DataGenService dataGenService) {
		this.dataGenService = dataGenService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/uploadDdlFile", method = RequestMethod.POST, produces = "application/vnd.ms-excel")
	public ResponseEntity<InputStreamResource> previewData(@RequestParam(name = "ddlFile") MultipartFile ddlFile,
			@RequestParam(name = "NumOfRecords") String numOfRecs,
			@RequestParam(name = "ExportType") String exportType) {

		List<ExcelSheetVO> ddlDefLst = null;

		if (exportType.equalsIgnoreCase("CSV")) {
			ddlDefLst = dataGenService.processCsvInputFile(ddlFile, ddlFile.getOriginalFilename());
		} else {
			ddlDefLst = dataGenService.processExcelInputFile(ddlFile);
		}
//Place where it is calling the service classes to generate the data
		for (ExcelSheetVO excelSheetVO : ddlDefLst) {
			excelSheetVO.setResult(
					dataGenService.processDdlDefs(excelSheetVO.getSheetDataStr(), Integer.parseInt(numOfRecs.trim())));
		}

		return dataGenService.getExcelAsHttpResponse(dataGenService.getResponseFileName(ddlFile.getOriginalFilename()),
				dataGenService.getExcelOutAsByteStream(ddlDefLst));
	}
}