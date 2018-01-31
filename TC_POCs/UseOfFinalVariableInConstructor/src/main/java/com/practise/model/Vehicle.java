package com.practise.model;

public class Vehicle {
	private String name;
	private final Car car;

	public Vehicle(String name, Car car) {
		this.name = name;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", car=" + car.getFeature() + "]";
	}
	
}
