package com.luxoft.test.service;

import java.util.List;
import java.util.Map;

import com.luxoft.test.model.VowelKey;

public interface DataFormatService {
	
	List<String> format(Map<VowelKey, Double> inputMap);

}
