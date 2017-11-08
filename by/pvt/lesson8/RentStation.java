package by.pvt.lesson8;

import java.util.Date;

import by.pvt.lesson8.units.Accessory;
import by.pvt.lesson8.units.Bike;
import by.pvt.lesson8.units.Category;
import by.pvt.lesson8.units.ElbowPads;
import by.pvt.lesson8.units.Equipment;
import by.pvt.lesson8.units.Helm;
import by.pvt.lesson8.units.KneePads;
import by.pvt.lesson8.units.Skateboard;
import by.pvt.lesson8.units.Snowboard;
import by.pvt.lesson8.users.Customer;
import by.pvt.lesson8.users.TestCustomer;

public class RentStation {

	private Equipment[] equipments = new Equipment[13];
	private Accessory[] accessories = new Accessory[14];
	private Customer[] customers = new Customer[20];
	private int equipCount = 0;
	private int accCount = 0;
	private int customerCount = 0;

	public RentStation() {
		Bike bike1 = new Bike(Category.Summer, "Bike1", 10d);
		Bike bike2 = new Bike(Category.Summer, "Bike2", 10d);
		Bike bike3 = new Bike(Category.Summer, "Bike3", 10d);
		Bike bike4 = new Bike(Category.Winter, "Bike4", 20d);
		Bike bike5 = new Bike(Category.Winter, "Bike5", 20d);

		Skateboard skateboard1 = new Skateboard(Category.Summer, "Skate1", 5d);
		Skateboard skateboard2 = new Skateboard(Category.Summer, "Skate2", 5d);
		Skateboard skateboard3 = new Skateboard(Category.Summer, "Skate3", 5d);
		Skateboard skateboard4 = new Skateboard(Category.Summer, "Skate4", 5d);

		Snowboard snowboard1 = new Snowboard(Category.Winter, "Board1", 8d);
		Snowboard snowboard2 = new Snowboard(Category.Winter, "Board2", 8d);
		Snowboard snowboard3 = new Snowboard(Category.Winter, "Board3", 8d);
		Snowboard snowboard4 = new Snowboard(Category.Winter, "Board4", 16d);

		equipments[0] = bike1;
		equipments[1] = bike2;
		equipments[2] = bike3;
		equipments[3] = bike4;
		equipments[4] = bike5;

		equipments[5] = skateboard1;
		equipments[6] = skateboard2;
		equipments[7] = skateboard3;
		equipments[8] = skateboard4;

		equipments[9] = snowboard1;
		equipments[10] = snowboard2;
		equipments[11] = snowboard3;
		equipments[12] = snowboard4;
		equipCount = 13;

		Helm helm1 = new Helm("He1", 2d);
		Helm helm2 = new Helm("He10", 2d);
		Helm helm3 = new Helm("He100", 2d);
		Helm helm4 = new Helm("He1000", 2d);
		Helm helm5 = new Helm("He10000", 2d);
		Helm helm6 = new Helm("He100000", 2d);

		KneePads kneePads1 = new KneePads("Knee1", 4d);
		KneePads kneePads2 = new KneePads("Knee2", 4d);
		KneePads kneePads3 = new KneePads("Knee3", 4d);
		KneePads kneePads4 = new KneePads("Knee4", 4d);

		ElbowPads elbowPads1 = new ElbowPads("Elb1", 6d);
		ElbowPads elbowPads2 = new ElbowPads("Elb12", 6d);
		ElbowPads elbowPads3 = new ElbowPads("Elb13", 6d);
		ElbowPads elbowPads4 = new ElbowPads("Elb14", 6d);

		accessories[0] = helm1;
		accessories[1] = helm2;
		accessories[2] = helm3;
		accessories[3] = helm4;
		accessories[4] = helm5;
		accessories[5] = helm6;

		accessories[6] = kneePads1;
		accessories[7] = kneePads2;
		accessories[8] = kneePads3;
		accessories[9] = kneePads4;

		accessories[10] = elbowPads1;
		accessories[11] = elbowPads2;
		accessories[12] = elbowPads3;
		accessories[13] = elbowPads4;
		accCount = 14;

		Customer testCustomer = new TestCustomer(IdGenerator.generate(), "Olga Andreeva");
		testCustomer.addEquipment(skateboard3);
		skateboard3.setHours(24);
		skateboard3.setStartDate(new Date(2017, 11, 7, 12, 0));
		skateboard3.setEndDate(new Date(2017, 11, 8, 15, 0));
		skateboard3.setRented(true);
		testCustomer.addAccessory(elbowPads2);
		addCustomer(testCustomer);

	}

	public Customer getTestCustomer() {
		return customers[0];
	}

	public Customer getCustomer(int i) {
		if (i < customerCount && i > 0) {
			System.out.println("¬ качестве тукущего выбран пользователь " + customers[i].toString());
			return customers[i];
		}
		System.out.println("Ќе верный номер пользовател€.");
		return customers[0];
	}

	public void rent(Customer customer, int equip, int hours) {
		Equipment equipment = equipments[equip];
		equipment.start();
		equipment.setHours(hours);
		customer.addEquipment(equipment);

		System.out.println(
				"Ёкипировка " + equipment.toString() + " успешно вз€та в прокат клиентом " + customer.toString());
	}

	public void addCustomer(Customer customer) {
		if (customerCount < customers.length) {
			customers[customerCount] = customer;
			customerCount++;
		}
	}

	public void printEquipment() {
		System.out.println("—писок доступного снар€жени€:");

		for (int i = 0; i < equipCount; i++) {
			if (!equipments[i].isRented()) {
				System.out.println((i + 1) + ". " + equipments[i].toString());
			}
		}

		System.out.println();
	}

	public void printRentedEquipment() {
		System.out.println("—писок снар€жени€ в прокате:");
		for (int i = 0; i < equipCount; i++) {
			if (equipments[i].isRented()) {
				System.out.println((i + 1) + ". " + equipments[i].toString());
			}
		}
		System.out.println();
	}

	public void printRentedEquipmentByCustomer(Customer customer) {
		System.out.println("—писок снар€жени€ вз€того клиентом " + customer.toString() + ":");
		customer.printEquipments();
		System.out.println();
	}

	public void printCustomers() {
		for (int i = 0; i < customerCount; i++) {
			System.out.println((i + 1) + ". " + customers[i].toString());
		}
	}

}
