package com.luxoft.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.luxoft.test.model.VowelKey;

public class DefaultDataFormatServiceTest {
	
	private DataFormatService dataFormatService = new DefaultDataFormatService();
	
	@Test
	public void format_EmptyInputMap_EmptyListReturns() {
		List<String> result = dataFormatService.format(Maps.newHashMap());
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void format_InputSingleWordTwoVowel_ListReturns() {
		Map<VowelKey, Double> inputMap = new HashMap<>();
		inputMap.put(new VowelKey(Sets.newHashSet("e", "i"), 6), 2.0);

		List<String> result = dataFormatService.format(inputMap);
		assertEquals(Collections.singletonList("({e, i}, 6) -> 2.0"), result);
	}
	
	@Test
	public void format_InputMultipleWordMultipleVowel_ListReturns() {
		Map<VowelKey, Double> inputMap = new HashMap<>();
		inputMap.put(new VowelKey(Sets.newHashSet("e", "i"), 6), 2.0);
		inputMap.put(new VowelKey(Sets.newHashSet("a", "o"), 6), 2.5);
		inputMap.put(new VowelKey(Sets.newHashSet("a", "e"), 4), 2.0);

		List<String> result = dataFormatService.format(inputMap);
		assertEquals(Arrays.asList("({a, o}, 6) -> 2.5", "({e, i}, 6) -> 2.0", "({a, e}, 4) -> 2.0"), result);
	}

}
