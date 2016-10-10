package task3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle {

	private String type;
	private String model;
	private double power;
	private double fuelConsumption;
	private int yearProduced;
	private String licenceNo;
	private double distanceTravelled;
	private int weight;
	private String color;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String type, String model, double power, double fuelConsumption, int yearProduced,
			double distanceTravelled, int weight, String color) {
		this.setType(type);
		this.setModel(model);
		this.setPower(power);
		this.setDistanceTravelled(distanceTravelled);
		this.setFuelConsumption(fuelConsumption);
		this.setYearProduced(yearProduced);
		this.setWeight(weight);
		this.setColor(color);
	}
	
	public Vehicle(String type, String model, double power, double fuelConsumption, int yearProduced, String licenceNo,
			double distanceTravelled, int weight, String color) {
		this.setType(type);
		this.setModel(model);
		this.setPower(power);
		this.setFuelConsumption(fuelConsumption);
		this.setYearProduced(yearProduced);
		this.setLicenceNo(licenceNo);
		this.setDistanceTravelled(distanceTravelled);
		this.setWeight(weight);
		this.setColor(color);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	public int getYearProduced() {
		return yearProduced;
	}
	public void setYearProduced(int yearProduced) {
		this.yearProduced = yearProduced;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(double distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public double getInsurancePrice(int carAge, String type) {
		double priceInsurance = 0;
		double typeCoefficient = 0;
		switch(type) {
		case "car":
			typeCoefficient = 1.00;
			break;
		case "suv":
			typeCoefficient = 1.12;
			break;
		case "truck":
			typeCoefficient = 1.20;
			break;
		case "motorcycle":
			typeCoefficient = 1.50;
			break;
		default:
			System.out.println("Not available data!");
			break;
		}
		priceInsurance = ((power * 0.16) * (carAge * 1.25) * (fuelConsumption * 0.05) * typeCoefficient);
		return priceInsurance;
	}
	
	public double caluclatePriceTravel(double fuelprice, double fuelConsumption, double distance) {
		double travelCost = 0;
		travelCost = (fuelprice * fuelConsumption) * (distance /100);
		return travelCost;
	}
	
	public void vehicleMotor(Vehicle venicle, double fuelprice, int numberOfCars) {
		Scanner scanner = new Scanner(System.in);
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		do {
			System.out.println("Enter:type, model, power, fuelConsumption, yearProduced, distanceTravelled, weight, String color");			
			System.out.println("Type");
			venicle.setType(scanner.next());
			System.out.println("Model");
			venicle.setModel(scanner.next());
			System.out.println("Power");
			venicle.setPower(scanner.nextDouble());
			System.out.println("FuelConsumption");
			venicle.setFuelConsumption(scanner.nextDouble());
			System.out.println("Year produced");
			venicle.setYearProduced(scanner.nextInt());
			System.out.println("Distance travelled");
			venicle.setDistanceTravelled(scanner.nextDouble());
			System.out.println("Weight");
			venicle.setWeight(scanner.nextInt());
			System.out.println("Color");
			venicle.setColor(scanner.next());
			vehicles.add(new Vehicle(venicle.type, 
									 venicle.model,
									 venicle.power,
									 venicle.fuelConsumption,
									 venicle.yearProduced,
									 venicle.distanceTravelled,
									 venicle.weight,
									 venicle.color));
			numberOfCars--;
		}while(numberOfCars != 0);
		
		for(Vehicle veh : vehicles) {
			int number = 0;
			DecimalFormat decimalFormat = new DecimalFormat("0000");                
			for(int index = 0; index < vehicles.size(); index++) {
				number++;
				vehicles.get(index).setLicenceNo(decimalFormat.format(number));
			}
			
			System.out.println(veh.getModel() + " " +
						   veh.getYearProduced() + " " +
						   veh.getColor() + " " +
						   veh.getDistanceTravelled() + 
						   " Insurance cost: " + veh.getInsurancePrice(veh.getYearProduced(), veh.getType()) +
						   " Travel cost " + veh.caluclatePriceTravel(fuelprice, veh.getFuelConsumption(), veh.getDistanceTravelled()) + 
						   "Licence number " + veh.getLicenceNo());
		}
	}
}
