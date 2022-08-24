package com.luxoft.test.model;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class VowelKey {

	private Set<String> vowels;
	private final int length;

	public VowelKey(Set<String> vowels, int length) {
		super();
		this.vowels = vowels;
		this.length = length;
	}

	public Set<String> getVowels() {
		return vowels;
	}

	public void setVowels(Set<String> vowels) {
		this.vowels = vowels;
	}

	public int getLength() {
		return length;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.vowels, this.length);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass())
			return false;

		if (this == obj)
			return true;

		VowelKey objVowelKey = (VowelKey) obj;
		return Objects.equals(vowels, objVowelKey.vowels) && length == objVowelKey.length;

	}

	@Override
	public String toString() {
		return new StringJoiner(", ", VowelKey.class.getSimpleName() + "[", "]").add("vowels=" + vowels)
				.add("length=" + length).toString();
	}

}
