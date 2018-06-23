package pl.sdacademy.tdd;

import java.util.HashSet;
import java.util.Set;

public class Anagramy {

	public static Set<String> converter(String str) {

		char strCharList[]=str.toCharArray();

		String cha[] = str.split("");
		Set<String> anagram = new HashSet<>();



		for (int i = 0; i < cha.length; i++) {
			for (int j = 0; j < cha.length; j++) {
				if(cha[i]!=cha[j]) {
					anagram.add(cha[i] + cha[j]);
				}
			}
		}
		return anagram;

		//return new String[]{"siep","pies","epis"};


	}

}
