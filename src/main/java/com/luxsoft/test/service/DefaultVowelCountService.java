package com.luxsoft.test.service;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;
import com.luxsoft.test.model.FinalVowelCount;
import com.luxsoft.test.model.VowelKey;

public class DefaultVowelCountService implements VowelCountService {

	private final static List<String> VOWELS = Arrays.asList("a", "e", "i", "o", "u");

	@Override
	public Map<VowelKey, Double> count(List<String> input) {

		List<String> words = new ArrayList<>();

		input.forEach(line -> {
			String removeSpecialCharactors = line.replaceAll("[^a-zA-Z0-9]", " ");
			words.addAll(Arrays.asList(removeSpecialCharactors.split(" ")));
		});

		return words.stream().map(word -> {
			List<String> vowelsInWord = word.chars().map(Character::toLowerCase).mapToObj(c -> String.valueOf((char) c))
					.filter(VOWELS::contains).map(String::valueOf).collect(Collectors.toList());
			return new FinalVowelCount(new VowelKey(Sets.newHashSet(vowelsInWord), word.length()), vowelsInWord.size());
		}).collect(groupingBy(FinalVowelCount::getVowelKey, averagingDouble(FinalVowelCount::getAverageVowels)));

	}

}
