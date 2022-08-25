package com.luxoft.test.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DefaultFileWriteService implements FileWriteService {

	@Override
	public void printFile(List<String> data, String outputFileName) throws IOException {
		Files.write(Paths.get(outputFileName), data);
	}

}
