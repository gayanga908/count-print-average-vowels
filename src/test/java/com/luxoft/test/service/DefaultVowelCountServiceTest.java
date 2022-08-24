package com.luxoft.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Sets;
import com.luxoft.test.model.VowelKey;

public class DefaultVowelCountServiceTest {

	private VowelCountService vowelCountService = new DefaultVowelCountService();

	@Test
	public void count_EmptyInputList_EmptyMapReturns() {
		Map<VowelKey, Double> result = vowelCountService.count(Collections.emptyList());
		assertTrue(result.isEmpty());
	}

	@Test
	public void count_InputSingleWordTwoVowel_MapReturns() {
		Map<VowelKey, Double> expected = new HashMap<>();
		expected.put(new VowelKey(Sets.newHashSet("e", "i"), 6), 2.0);

		Map<VowelKey, Double> result = vowelCountService.count(Collections.singletonList("Single"));
		assertEquals(expected, result);
	}

	@Test
	public void count_InputMultipleWordMultipleVowel_MapReturns() {
		Map<VowelKey, Double> expected = new HashMap<>();
		expected.put(new VowelKey(Sets.newHashSet("a", "o"), 5), 2.0);
		expected.put(new VowelKey(Sets.newHashSet("a", "o"), 6), 2.5);
		expected.put(new VowelKey(Sets.newHashSet("a", "e"), 4), 2.0);

		Map<VowelKey, Double> result = vowelCountService.count(Collections.singletonList("Platon made bamboo boats."));
		assertEquals(expected, result);
	}

}
