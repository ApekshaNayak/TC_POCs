package com.practise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practise.model.Car;
import com.practise.model.Vehicle;

@SpringBootApplication
public class UseOfFinalVariableInConstructorApplication {

	public static void main(String[] args) {
		Car car1 = new Car("Honda", "City", "Grey", "ACN");
		Car car2 = new Car("Toyota", "Tacoma", "Black", "SVT");
		Car car3 = new Car("Ford", "Taurus", "White", "SOS");
		Vehicle veh1 =  new Vehicle("Car", car1);
		Vehicle veh2 =  new Vehicle("Car", car2);
		System.out.println("Vehicle 1: "+veh1);
		System.out.println("Vehicle 2: "+veh2);
		SpringApplication.run(UseOfFinalVariableInConstructorApplication.class, args);
	}
}
