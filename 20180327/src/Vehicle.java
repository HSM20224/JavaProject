
public class Vehicle {
	private int speed;

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	void turn() {
	}

	public Vehicle(int speed) {
		this.speed = speed;
	}
}

class Car extends Vehicle {

	private boolean sunroof = false;

	public boolean issunroof() {
		return sunroof;
	}

	public void setsunroof(boolean sunroof) {
		this.sunroof = sunroof;
	}

	public Car(int speed, boolean sunroof) {
		super(speed);
		this.sunroof = sunroof;
	}
}

class Truck extends Vehicle {

	private boolean freight = false;

	public boolean isFreight() {
		return freight;
	}

	public void setFreight(boolean freight) {
		this.freight = freight;
	}

	public Truck(int speed, boolean feight) {
		super(speed);
		this.freight = feight;
	}
}

class Bus extends Vehicle {
	private boolean bell = false;

	public boolean isBell() {
		return bell;
	}

	public void setBell(boolean bell) {
		this.bell = bell;
	}

	public Bus(int speed, boolean bell) {
		super(speed);
		this.bell = bell;
	}
}
