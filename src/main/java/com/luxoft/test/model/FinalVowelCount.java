package com.luxoft.test.model;

import java.util.Objects;
import java.util.StringJoiner;

public class FinalVowelCount {
	private final VowelKey vowelKey;
	private final double averageVowels;

	public FinalVowelCount(VowelKey vowelKey, double averageVowels) {
		this.vowelKey = vowelKey;
		this.averageVowels = averageVowels;
	}

	public VowelKey getVowelKey() {
		return vowelKey;
	}

	public double getAverageVowels() {
		return averageVowels;
	}

	@Override
	public int hashCode() {
		return Objects.hash(vowelKey, averageVowels);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass())
			return false;

		if (this == obj)
			return true;

		FinalVowelCount objFinalVowelCount = (FinalVowelCount) obj;
		return Objects.equals(vowelKey, objFinalVowelCount.vowelKey)
				&& averageVowels == objFinalVowelCount.averageVowels;

	}

	@Override
	public String toString() {
		return new StringJoiner(", ", FinalVowelCount.class.getSimpleName() + "[", "]").add("vowelKey=" + vowelKey)
				.add("averageVowels=" + averageVowels).toString();
	}
}
