package pl.sdacademy.tadeustdd;

import java.util.Scanner;

public class RepairCar {

	GasStation gasStation = new GasStation();

	Scanner ask = new Scanner(System.in);
	int answer;

	public RepairCar(CarTDD car) {
		System.out.println("Co chcesz zrobić?");
		System.out.println("0 - tankowanie, 1 - mycie, 2 - wymiana kół");
		answer = ask.nextInt();

		switch (answer) {
			case 0:
				car.setFuelLevel(car.MAX_LEVEL);
				// dodać kwotę do zapłaty
				break;
			case 1:
				gasStation.carWash(car);
				break;
			case 2:
				gasStation.changeTires(car);
				break;
			default:
				System.out.println("Co chcesz zrobić?");
				System.out.println("0 - tankowanie, 1 - mycie, 2 - wymiana kół");
				answer = ask.nextInt();
		}

	}
}
