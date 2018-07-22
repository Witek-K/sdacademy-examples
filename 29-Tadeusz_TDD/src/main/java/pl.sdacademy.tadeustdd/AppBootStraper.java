package pl.sdacademy.tadeustdd;

import java.util.Scanner;

import static pl.sdacademy.tadeustdd.CarType.*;

public class AppBootStraper {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int answerFuel;
		float answerFloat;
		float answerBurn;

		System.out.println("Rozpoczynamy wyścig!\n");

		CarTDD car = null;


		System.out.println("Podaj pojemność baku: ");
		answerFloat = input.nextFloat();

		System.out.println("Podaj spalanie: ");
		answerBurn = input.nextFloat();

		System.out.println("Podaj rodzaj paliwa:\n0 - ON, 1 - Pb, 2 - AC/DC");
		answerFuel = input.nextInt();

		switch (answerFuel) {
			case 0:
				car = new CarTDD(ON, answerFloat, answerBurn);
				break;
			case 1:
				car = new CarTDD(PB,answerFloat, answerBurn);
				break;
			case 2:
				car = new CarTDD(ACDC,answerFloat, answerBurn);
				break;
			default:
				System.out.println("Podaj rodzaj paliwa:");
				System.out.println("0 - ON, 1 - Pb, 2 - AC/DC");
				answerFuel = input.nextInt();
		}






		Race race = new Race();
		System.out.println("Podaj liczbę okrążeń: ");
		int i = input.nextInt();

		race.lap(car,i);


	}
}
