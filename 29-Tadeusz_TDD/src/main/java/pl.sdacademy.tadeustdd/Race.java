package pl.sdacademy.tadeustdd;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Race {

	void Parameters(CarTDD car){
		System.out.println("Poziom paliwa wynosi: " + df.format(car.fuelLevel()) + " l");
		System.out.println("Poziom brudu wynosi: " + car.dirtLevel + "%");
		System.out.println("Poziom zużycia opon wynosi: " + car.wheels.usageLevel + "%");
	}

	DecimalFormat df = new DecimalFormat(".##");
	Scanner askForPitstop = new Scanner(System.in);

	char answer;


	void lap(CarTDD car, int i) {

		int dirtIncrease = 2;
		int finishedLaps;

		for (finishedLaps = 0; finishedLaps < i; finishedLaps++) {
			if (car.fuelLevel()>car.fuelUsage && car.dirtLevel<(100-dirtIncrease) && car.wheels
				.usageLevel<(100-car.wheels.usageParameter)) {

			car.setFuelLevel(car.fuelLevel() - ((car.fuelUsage)));
			car.setDirtLevel(car.getDirtLevel() + (dirtIncrease));
			car.wheels.setUsageLevel(car.wheels.getUsageLevel() + (car.wheels.usageParameter));

			if (car.fuelLevel() <= 0.2 * car.MAX_LEVEL || car.dirtLevel > 90) {
				Parameters(car);
				System.out.println("Pozostało okrążeń: " + (i - finishedLaps));
				System.out.println("Czy kontynuować?  Y/N");
				answer = askForPitstop.nextLine().toUpperCase().charAt(0);
				switch (answer) {
					case 'Y':
						break;

					case 'N':
						new RepairCar(car);
						break;

					default: {
						System.out.println("Czy kontynuować?  Y/N");
						answer = askForPitstop.nextLine().toUpperCase().charAt(0);
					}

				}

				System.out.println();
			}

		}
		else{
				if(car.fuelLevel()<=car.fuelUsage)
					System.out.println("Pusty bak!!");
				else if (car.dirtLevel>=(100-dirtIncrease))
					System.out.println("Nic nie widzę!!");
				else //(car.wheels.usageLevel>=(100-car.wheels.usageParameter))
					System.out.println("Mam flaka!");

				break;
		}

		}

		System.out.println("Gratuluję, ukończyłeś wyścig! Statystyki: ");
		Parameters(car);
	}
}
