package com.practise.model;

public class Car {

	private String name;
	private String model;
	private String color;
	private String feature;
	
	public Car(String name, String model, String color, String feature) {
		super();
		this.name = name;
		this.model = model;
		this.color = color;
		this.feature = feature;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", model=" + model + ", color=" + color + ", feature=" + feature + "]";
	}
	
}
