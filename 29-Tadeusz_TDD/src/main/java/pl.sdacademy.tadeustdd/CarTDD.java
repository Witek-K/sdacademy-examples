package pl.sdacademy.tadeustdd;

public class CarTDD {

	private float tank;
	final float MIN_LEVEL = 0f;
	float MAX_LEVEL = 35f;
	private final CarType carType;
	int dirtLevel=0;
	float fuelUsage = 2;

	Wheels wheels = new Wheels();

	CarType getCarType(){
		return carType;
	}


	CarTDD(CarType carType){
		this.carType = carType;
	}

	CarTDD(CarType carType, float tankVolume){
		this.carType = carType;
		this.MAX_LEVEL = tankVolume;
		this.tank = tankVolume;
	}

	CarTDD(CarType carType, float tankVolume, float fuelUsage) {
		this.carType = carType;
		this.MAX_LEVEL = tankVolume;
		this.tank = tankVolume;
		this.fuelUsage = fuelUsage;
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
