package com.luxoft.test.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Joiner;
import com.luxoft.test.model.VowelKey;

public class DefaultDataFormatService implements DataFormatService {

	@Override
	public List<String> format(Map<VowelKey, Double> inputMap) {
		String template = "({%s}, %d) -> %s";

		List<String> formatedList = inputMap.entrySet().stream().map(input -> {
			VowelKey key = input.getKey();
			Double average = input.getValue();
			return String.format(Locale.US, template, Joiner.on(", ").join(key.getVowels()), key.getLength(), average);
		}).collect(Collectors.toList());

		return formatedList;
	}

}
