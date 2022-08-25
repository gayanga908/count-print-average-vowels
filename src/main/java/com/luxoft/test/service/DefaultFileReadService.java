package com.luxoft.test.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultFileReadService implements FileReadService {

	@SuppressWarnings("resource")
	@Override
	public List<String> readFile(String fileName) {
		Stream<String> inputStream;

		try {
			inputStream = Files.lines(FileSystems.getDefault().getPath(fileName));
		} catch (IOException exception) {
			throw new RuntimeException(String.format("Error occurred while reading the file %s", fileName), exception);
		}
		return inputStream.collect(Collectors.toList());
	}

}
