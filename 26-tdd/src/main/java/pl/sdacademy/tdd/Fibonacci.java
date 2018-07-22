package pl.sdacademy.tdd;




import java.util.Scanner;


public class Fibonacci {


	public static int Fibonacci(int number)
	{
		if (number == 0 || number == 1)
		{
			return number;
		}
		return (Fibonacci(number - 1)) + (Fibonacci(number - 2));
	}
	public static void main(String[] args) {
		long N;
		Scanner odczyt = new Scanner(System.in);
		System.out.println("Podaj liczbę: ");

		N = odczyt.nextInt();


		//System.out.println(start);

		for (int i = 1; i <= N; i++) {

			long start = System.currentTimeMillis();

			System.out.println(i + ": " + Fibonacci(i));

			long end = System.currentTimeMillis();
			System.out.println("Elapsed time: " + (end-start));
		}



	}


}