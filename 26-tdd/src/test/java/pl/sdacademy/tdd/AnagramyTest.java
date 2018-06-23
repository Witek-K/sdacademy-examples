package pl.sdacademy.tdd;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class AnagramyTest {

	@DisplayName("should convert pies to siep")
	@Test
	@Disabled

	void pies(){
		// given
		String str = "pies";
		// when
		Set<String> piescidelko = Anagramy.converter(str);
		// then
		assertThat(piescidelko).contains("siep");
	}

	@DisplayName("should convert pies to epis")
	@Test
	@Disabled

	void epis(){
		// given
		String str = "pies";
		// when
		Set<String> piescidelko = Anagramy.converter(str);
		// then
		assertThat(piescidelko).contains("epis");
	}

	@DisplayName("should convert pies to epis")
	@Test
	@Disabled

	void wszystkie(){
		// given
		String str = "pies";
		// when
		Set<String> piescidelko = Anagramy.converter(str);
		// then
		assertThat(piescidelko).contains("epis");
	}

	@DisplayName("should return all anagrams od oj")
	@Test

	void wszystkieAnagramy(){
		// given
		String str = "oj";
		// when
		Set<String> piescidelko = Anagramy.converter(str);
		// then
		assertThat(piescidelko).containsOnly("oj","jo");
	}

	@DisplayName("should return all anagrams od kot")
	@Test

	void wszystkieKoty(){
		// given
		String str = "kot";
		// when
		Set<String> piescidelko = Anagramy.converter(str);
		// then
		assertThat(piescidelko).containsOnly("kot","kto","otk","okt","tko","tok");
	}

}
