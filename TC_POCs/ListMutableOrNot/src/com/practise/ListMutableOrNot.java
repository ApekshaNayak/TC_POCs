package com.practise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.practise.model.Car;

public class ListMutableOrNot {
	
	public static void main(String[] args) {
		List<Car> carList = new ArrayList<>();

		Car car1 = new Car("Toyota", "Prius", "Burgandy", "ACN");
		Car car2 = new Car("Ford", "Taurus", "Grey", "SOS");
		
		carList.add(car1);
		carList.add(car2);
		
		Iterator<Car>iterator = carList.iterator();
		
		while(iterator.hasNext()){
			Car car = iterator.next();
			System.out.println(car.getName()+" :"+car.getFeature());
		}
		
		for(Car car: carList) {
			car.setFeature("DHC");
			System.out.println(car.getName()+" 1:"+car.getFeature());
		}
		
		Iterator<Car>iterator1 = carList.iterator();
		while(iterator1.hasNext()){
			Car car = iterator1.next();
			System.out.println(car.getName()+" 2:"+car.getFeature());
		}
		
	}
}
