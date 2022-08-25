package com.luxoft.test.facade;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.luxoft.test.model.VowelKey;
import com.luxoft.test.service.DataFormatService;
import com.luxoft.test.service.FileReadService;
import com.luxoft.test.service.FileWriteService;
import com.luxoft.test.service.VowelCountService;

public class VowelCountPrinter {
	
	private FileReadService fileReadService;
	private VowelCountService vowelCountService;
	private DataFormatService dataFormatService;
	private FileWriteService fileWriteService;
	
	public VowelCountPrinter(FileReadService fileReadService, VowelCountService vowelCountService,
			DataFormatService dataFormatService, FileWriteService fileWriteService) {
		this.fileReadService = fileReadService;
		this.vowelCountService = vowelCountService;
		this.dataFormatService = dataFormatService;
		this.fileWriteService = fileWriteService;
	}

	public void countAndPrint(String inputFileName, String outputFileName) {
		
		List<String> inputs = fileReadService.readFile(inputFileName);
		
		Map<VowelKey, Double> countedData = vowelCountService.count(inputs);
		
		List<String> formatedList = dataFormatService.format(countedData);
		
		try {
			fileWriteService.printFile(formatedList, outputFileName);
		} catch (IOException exception) {
			throw new RuntimeException("Error occured when printing the file", exception);
		}
	}

}
