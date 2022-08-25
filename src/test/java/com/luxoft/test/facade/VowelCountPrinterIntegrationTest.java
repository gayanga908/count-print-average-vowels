package com.luxoft.test.facade;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.luxoft.test.service.DataFormatService;
import com.luxoft.test.service.DefaultDataFormatService;
import com.luxoft.test.service.DefaultFileReadService;
import com.luxoft.test.service.DefaultFileWriteService;
import com.luxoft.test.service.DefaultVowelCountService;
import com.luxoft.test.service.FileReadService;
import com.luxoft.test.service.FileWriteService;
import com.luxoft.test.service.VowelCountService;

public class VowelCountPrinterIntegrationTest {

	public static final String INPUT_FILE = "INPUT.TXT";
	public static final String OUTPUT_FILE = "OUTPUT.TXT";
	private FileReadService fileReadService = new DefaultFileReadService();
	private VowelCountService vowelCountService = new DefaultVowelCountService();
	private DataFormatService dataFormatService = new DefaultDataFormatService();
	private FileWriteService fileWriteService = new DefaultFileWriteService();

	@AfterEach
	void afterClass() throws IOException {
		removeFile(INPUT_FILE);
		removeFile(OUTPUT_FILE);
	}

	private void removeFile(String filename) throws IOException {
		Files.deleteIfExists(Paths.get(filename));
	}

	@Test
	void processesInputWith() throws IOException {
		Files.write(Paths.get(INPUT_FILE),
				Arrays.asList("Platon made bamboo boats."));

		new VowelCountPrinter(fileReadService, vowelCountService, dataFormatService, fileWriteService)
				.countAndPrint(INPUT_FILE, OUTPUT_FILE);

		assertThat(Files.lines(Paths.get(OUTPUT_FILE))).containsExactly("({a, o}, 5) -> 2.0",
				"({a, o}, 6) -> 2.5", "({a, e}, 4) -> 2.0");
	}

}
