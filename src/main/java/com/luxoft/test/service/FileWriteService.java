package com.luxoft.test.service;

import java.io.IOException;
import java.util.List;

public interface FileWriteService {
	
	void printFile(List<String> data, String outputFileName) throws IOException;

}
