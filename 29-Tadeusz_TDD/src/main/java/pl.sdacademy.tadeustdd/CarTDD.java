package pl.sdacademy.tadeustdd;

public class CarTDD {

	private float tank;
	final float MIN_LEVEL = 0f;
	private float MAX_LEVEL = 35f;
	private final CarType carType;
	private int dirtLevel;
	Wheels wheels = new Wheels();

	CarType getCarType(){
		return carType;
	}


	CarTDD(CarType carType, float tankVolume){
		this.carType = carType;
		this.MAX_LEVEL = tankVolume;
	}


	float fuelLevel(){
		return tank;
	}

	 void setFuelLevel(float fuelLevel) {
		this.tank=fuelLevel;
	}

	float freeTankSpace() {
		return MAX_LEVEL - fuelLevel();
	}


	public int getDirtLevel() {
		return dirtLevel;
	}

	public void setDirtLevel(int dirtLevel) {
		this.dirtLevel = dirtLevel;
	}
}
