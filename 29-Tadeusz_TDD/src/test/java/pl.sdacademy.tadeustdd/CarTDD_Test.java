package pl.sdacademy.tadeustdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static pl.sdacademy.tadeustdd.CarType.*;

class CarTDD_Test{

	private CarTDD carTDD;
	@BeforeEach
	void setup(){
		carTDD = new CarTDD(PB,35);

	GasStation gasStation = new GasStation();

	}



	@DisplayName("should check the level of fuel in bag at beginning")
	@Test
	void Test01(){

		//given
		carTDD.setFuelLevel(30);
		//when

		//then
		assertThat(carTDD.fuelLevel()).isEqualTo(30);
}

	@DisplayName("should check how many fuel is needed to fully fill in")
		@Test
		void Test02(){

		//given
		carTDD.setFuelLevel(10.5f);
		//when

		//then
		assertThat(carTDD.freeTankSpace()).isEqualTo(24.5f);
	}

	@DisplayName("should count the price of fully tanked car")
	@Test
	void Test03(){

		//given
		carTDD.setFuelLevel(10.5f);
		GasStation gasStation = new GasStation();
		//when
		gasStation.setFuelPrice(5.20f);
		//then
		assertThat(gasStation.countPrice(carTDD.freeTankSpace())).isEqualByComparingTo(new BigDecimal(Float
			.toString
			(127.40f)));
	}

	@DisplayName("should count the price of fully tanked car with fuel type dependency")
	@Test
	void Test04(){

		//given
		carTDD.setFuelLevel(10.5f);
		GasStation gasStation = new GasStation();
		//when
		CarType type = carTDD.getCarType();
		//then
		assertThat(gasStation.countPrice(carTDD.freeTankSpace(),(type))).isEqualByComparingTo(new BigDecimal(Float
			.toString
			(104.86f)));
	}

	@DisplayName("should count the price of requested amount of fuel")
	@Test
	void Test05(){

		//given
		GasStation gasStation = new GasStation();
		//when
		CarType type = carTDD.getCarType();
		float reqestedAmount = 5.0f;
		//then
		assertThat(gasStation.countPrice(reqestedAmount,(type))).isEqualByComparingTo(new BigDecimal(Float
			.toString
				(21.4f)));
	}

	@DisplayName("should wash a car by setting dirtLevel to zero")
	@Test
	void Test06() {

		//given
		carTDD.setDirtLevel(20);
		GasStation gasStation = new GasStation();
		//when
		gasStation.carWash(carTDD);
		//then
		assertThat(carTDD.getDirtLevel()).isEqualTo(0);

	}

	@DisplayName("should change the wheels by setting usage level to zero")
	@Test
	void Test07() {

		//given
		carTDD.wheels.setUsageLevel(45);
		GasStation gasStation = new GasStation();
		//when
		gasStation.changeTires(carTDD);
		//then
		assertThat(carTDD.wheels.getUsageLevel()).isEqualTo(0);

	}


	@DisplayName("should allow to race the 10 laps")
	@Test
	void Test08() {

		//given
		CarTDD raceCar = new CarTDD(ON, 40, 3.2f);
		//when
		Race race = new Race();
		race.lap(raceCar, 100);
		//then
		assertThat(raceCar.getDirtLevel()).isEqualTo(24);
		assertThat(raceCar.fuelLevel()).isCloseTo(1.6f, withinPercentage(1));
		assertThat(raceCar.wheels.usageLevel).isEqualTo(36);
	}






}