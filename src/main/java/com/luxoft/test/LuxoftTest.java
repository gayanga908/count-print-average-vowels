package com.luxoft.test;

import java.io.IOException;
import com.luxoft.test.facade.VowelCountPrinter;
import com.luxoft.test.service.DataFormatService;
import com.luxoft.test.service.DefaultDataFormatService;
import com.luxoft.test.service.DefaultFileReadService;
import com.luxoft.test.service.DefaultFileWriteService;
import com.luxoft.test.service.DefaultVowelCountService;
import com.luxoft.test.service.FileReadService;
import com.luxoft.test.service.FileWriteService;
import com.luxoft.test.service.VowelCountService;

public class LuxoftTest {

	public static void main(String[] args) throws IOException {
		FileReadService fileReadService = new DefaultFileReadService();
		VowelCountService vowelCountService = new DefaultVowelCountService();
		DataFormatService dataFormatService = new DefaultDataFormatService();
		FileWriteService fileWriteService = new DefaultFileWriteService();

		new VowelCountPrinter(fileReadService, vowelCountService, dataFormatService, fileWriteService)
				.countAndPrint("INPUT.TXT", "OUTPUT.TXT");

	}

}
