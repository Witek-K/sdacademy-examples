package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


// TODO: write your tests inside this class
class FizzBuzzWhizzTest {

	// this is how a test look like
	@DisplayName("Check if the result of FizzBuzzWhizz isn't null")
	@Test
	void testNull() {
		// given
		int number = 0;
		// when
		String msg = FizzBuzzWhizz.msg(number);
		// then
		assertThat(msg).isNotEqualTo(null);
	}

	@DisplayName("Check if the result of FizzBuzzWhizz equals 1")
	@Test
	void testOne(){
		// given
		int number = 1;
		//when
		String msg = FizzBuzzWhizz.msg(number);
		//then
		assertThat(msg).isEqualTo("1");
	}

	@DisplayName("Check if the result of FizzBuzzWhizz equals 2")
	@Test
	void testTwo(){
		// given
		int number = 2;
		// when
		String msg = FizzBuzzWhizz.msg(number);
		// then
		assertThat(msg).isEqualTo("Whizz");
	}

	@DisplayName("Check if the result of FizzBuzzWhizz equals 3")
	@Test
	void testThree(){
		// given
		int number = 3;
		// when
		String msg = FizzBuzzWhizz.msg(number);
		// then
		assertThat(msg).isEqualTo("FizzWhizz");
	}

	@DisplayName("Check if the result of FizzBuzzWhizz equals 5")
	@Test
	void testFive(){
		// given
		int number = 5;
		// when
		String msg = FizzBuzzWhizz.msg(number);
		// then
		assertThat(msg).isEqualTo("BuzzWhizz");
	}

	@DisplayName("Check if the result of FizzBuzzWhizz equals 6")
	@Test
	void testSix(){
		// given
		int number = 6;
		// when
		String msg = FizzBuzzWhizz.msg(number);
		// then
		assertThat(msg).isEqualTo("Fizz");
	}

	@DisplayName("Check if the result of FizzBuzzWhizz equals 7")
	@Test
	void testSeven(){
		// given
		int number = 7;
		// when
		String msg = FizzBuzzWhizz.msg(number);
		// then
		assertThat(msg).isEqualTo("Whizz");
	}


	@DisplayName("Check if the result of FizzBuzzWhizz equals 10")
	@Test
	void testTen(){
		// given
		int number = 10;
		// when
		String msg = FizzBuzzWhizz.msg(number);
		// then
		assertThat(msg).isEqualTo("Buzz");
	}

	@DisplayName("Check if the result of FizzBuzzWhizz equals 15")
	@Test
	void testFifteen(){
		// given
		int number = 15;
		// when
		String msg = FizzBuzzWhizz.msg(number);
		// then
		assertThat(msg).isEqualTo("FizzBuzz");
	}

	@DisplayName("Check if the result of FizzBuzzWhizz equals 30")
	@Test
	void testThirty(){
		// given
		int number = 30;
		// when
		String txt = FizzBuzzWhizz.msg(number);
		// then
		assertThat(txt).isEqualTo("FizzBuzz");
	}

}

