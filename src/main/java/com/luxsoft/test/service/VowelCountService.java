package com.luxsoft.test.service;

import java.util.List;
import java.util.Map;

import com.luxsoft.test.model.VowelKey;

public interface VowelCountService {
	
	Map<VowelKey, Double> count(List<String> input);

}
