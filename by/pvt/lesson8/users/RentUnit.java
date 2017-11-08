package by.pvt.lesson8.users;

import java.util.Arrays;

import by.pvt.lesson8.units.Accessory;
import by.pvt.lesson8.units.Equipment;

public class RentUnit {

	private Equipment[] equipments = new Equipment[3];

	private Accessory[] accessories = new Accessory[10];

	private int equipCount = 0;
	private int accCount = 0;

	public Equipment[] getEquipments() {
		return equipments;
	}

	public Accessory[] getAccessories() {
		return accessories;
	}

	public int getEquipCount() {
		return equipCount;
	}

	public int getAccCount() {
		return accCount;
	}

	public void addEquipment(Equipment equipment) {
		if (equipCount < equipments.length) {
			equipments[equipCount] = equipment;
			equipCount++;
		} else {
			System.out.println("customer has equipments limit");
		}
	}

	public void addAccesory(Accessory accessory) {
		if (accCount < accessories.length) {
			accessories[accCount] = accessory;
			accCount++;
		} else {
            accessories = Arrays.copyOf(accessories, accCount + 10);
		}
	}
	
	public void delete(Equipment equipment) {
		if(equipCount > 0) {
			for (int i = 0; i < equipCount; i++) {
				Equipment rented = equipments[i];
				if (equipment.equals(rented)) {
					equipments[i].stop();
					equipments[i] = null;
					equipCount--;
				}
			}
		}
	}
	
	public void delete(Accessory accessory) {
		if(accCount > 0) {
			for (int i = 0; i < accCount; i++) {
				Accessory rented = accessories[i];
				if (accessory.equals(rented)) {
					accessories[i] = null;
					accCount--;
				}
			}
		}
	}
	
	public void printEquipment() {
		for (int i = 0; i < equipCount; i++) {
			if (equipments[i].isRented()) {
				System.out.println((i + 1) + ". " + equipments[i].toString());
			}
		}
		System.out.println();
	}

}
