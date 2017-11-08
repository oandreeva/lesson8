package by.pvt.lesson8.users;

import by.pvt.lesson8.units.Accessory;
import by.pvt.lesson8.units.Equipment;

public class Customer {

	private int id;
	private String name;
	protected RentUnit units;

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
		units = new RentUnit();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnits(RentUnit units) {
		this.units = units;
	}

	public Equipment[] getEquipments() {
		return units.getEquipments();
	}

	public Accessory[] getAccessories() {
		return units.getAccessories();
	}

	public void addEquipment(Equipment equipment) {
		units.addEquipment(equipment);
	}

	public void addAccessory(Accessory accessory) {
		units.addAccesory(accessory);
	}

	public void delete(Equipment equipment) {
		units.delete(equipment);
	}

	public void delete(Accessory accessory) {
		units.delete(accessory);
	}

	public void printEquipments() {
		units.printEquipment();
	}
	

	@Override
	public String toString() {
		return "Пользователь: " + name;
	}
}
