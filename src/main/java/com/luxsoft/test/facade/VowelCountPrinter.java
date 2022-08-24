package com.luxsoft.test.facade;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.luxsoft.test.model.VowelKey;
import com.luxsoft.test.service.DataFormatService;
import com.luxsoft.test.service.DefaultDataFormatService;
import com.luxsoft.test.service.DefaultFileWriteService;
import com.luxsoft.test.service.DefaultVowelCountService;
import com.luxsoft.test.service.FileWriteService;
import com.luxsoft.test.service.VowelCountService;

public class VowelCountPrinter {
	
	public void countAndPrint(List<String> inputs) {
		VowelCountService countService = new DefaultVowelCountService();
		Map<VowelKey, Double> countedData = countService.count(inputs);
		
		DataFormatService dataFormatService = new DefaultDataFormatService();
		List<String> formatedList = dataFormatService.format(countedData);
		
		FileWriteService fileWriteService = new DefaultFileWriteService();
		try {
			fileWriteService.printFile(formatedList);
		} catch (IOException exception) {
			throw new RuntimeException("Error occured when printing the file", exception);
		}
	}

}
