package pl.sdacademy.tadeustdd;

import java.math.BigDecimal;

public class GasStation {

	float fuelPrice;
	float ONPrice = 3.96f;
	float PbPrice = 4.28f;
	float AcDcPrice = 1.89f;

	public void setFuelPrice(float fuelPrice) {
		this.fuelPrice = fuelPrice;
	}


	public BigDecimal countPrice(float amountOfFuel) {


				return new BigDecimal(Float.toString(fuelPrice)).multiply(new BigDecimal(Float.toString
					(amountOfFuel)));
		}


	public BigDecimal countPrice(float amountOfFuel, CarType fuelType) {
		switch (fuelType){
		case PB:
			return new BigDecimal(Float.toString(PbPrice)).multiply(new BigDecimal(Float.toString(amountOfFuel)));
		case ON:
			return new BigDecimal(Float.toString(ONPrice)).multiply(new BigDecimal(Float.toString
				(amountOfFuel)));
		case ACDC:
			return new BigDecimal(Float.toString(AcDcPrice)).multiply(new BigDecimal(Float.toString
				(amountOfFuel)));

			default:
		return new BigDecimal(Float.toString(fuelPrice)).multiply(new BigDecimal(Float.toString
			(amountOfFuel)));
	}}

	public void carWash(CarTDD carTDD) {
		carTDD.setDirtLevel(0);
	}

	public void changeTires(CarTDD carTDD) {
		carTDD.wheels.setUsageLevel(0);
	}
}
