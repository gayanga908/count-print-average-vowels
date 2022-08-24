package com.luxsoft.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.luxsoft.test.facade.VowelCountPrinter;

public class LuxsoftTest {

	public static void main(String[] args) throws IOException {
		
		List<String> data = new ArrayList<>();
		
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream("INPUT.txt");
		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		BufferedReader reader = new BufferedReader(streamReader);
		for (String line; (line = reader.readLine()) != null;) {
			data.add(line);
		}
		
		new VowelCountPrinter().countAndPrint(data);
		
		

	}


}
