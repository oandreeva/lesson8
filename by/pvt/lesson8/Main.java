package by.pvt.lesson8;

import java.util.Scanner;

import by.pvt.lesson8.units.Equipment;
import by.pvt.lesson8.users.Customer;

public class Main {
	private static Customer currentCustomer;

	public static void main(String[] args) {
		
		RentStation a = new RentStation();
		currentCustomer = a.getTestCustomer();
		a.printEquipment();

		mainMenu();

		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		while (!isExit) {

			switch (sc.nextLine()) {
			case "1":
				createUserMenu(sc, a);
				break;
			case "2":
				selectCustomerMenu(sc, a);
				break;
			case "3":
				a.printEquipment();
				break;
			case "4":
				a.printRentedEquipment();
				break;
			case "5":
				rentCurrent(sc, a);
				break;
			case "6":
				returnEquipment(sc, a);
				break;
			case "7":
				System.out.println("В разработке 7");
				break;
			case "0":
				System.out.println("Выход");
				isExit = true;
				break;
			default:
				mainMenu();
				break;
			}
		}

	}

	private static void mainMenu() {
		System.out.println("1. Создать пользователя.");
		System.out.println("2. Выбрать пользователя из списка в качестве текущего.");
		System.out.println("3. Просмотреть список снаряжения, доступного к прокату.");
		System.out.println("4. Просмотреть список снаряжения, взятого в прокат.");
		System.out.println("5. Взять конкретный элемент снаряжения в прокат.");
		System.out.println("6. Вернуть снаряжение.");
		System.out.println("7. Вывести список снаряжения, которое не вернули на станцию в срок.");
		System.out.println("0. Завершить работу пункта проката.");
	}

	private static void createUserMenu(Scanner sc, RentStation station) {
		System.out.println("Введите имя пользователя:");

		String name = sc.nextLine();
		Customer customer = new Customer(IdGenerator.generate(), name);
		station.addCustomer(customer);
		currentCustomer = customer;

		System.out.println("Пользователь с именем " + customer.getName() + " создан.");
	}

	public static void selectCustomerMenu(Scanner sc, RentStation station) {
		System.out.println("Выберите пользователя");
		station.printCustomers();
		currentCustomer = station.getCustomer(Integer.parseInt(sc.nextLine()) - 1);
	}

	public static void rentCurrent(Scanner sc, RentStation station) {
		System.out.println("Выберите экипировку из списка которую хотите арендовать:");
		station.printEquipment();
		
		int equip = Integer.valueOf(sc.nextLine()) - 1;
		
		System.out.println("На какое кол-во часов хотите арендовать?");
		
		int hours = Integer.valueOf(sc.nextLine());
		
		station.rent(currentCustomer, equip, hours);
	}
	
	public static void returnEquipment(Scanner sc, RentStation station) {
		System.out.println("Выберите экипировку из списка которую хотите вернуть:");
		station.printRentedEquipmentByCustomer(currentCustomer);
		int equip = Integer.valueOf(sc.nextLine()) - 1;
		Equipment equipment = currentCustomer.getEquipments()[equip];
		currentCustomer.delete(equipment);
		System.out.println("Экипировка " + equipment.toString() + " успешно возвращена.");
		
	}

	private static void rentMenu(Scanner sc) {
		boolean isExit = false;
		while (!isExit) {
			System.out.println("1. Создать пользователя.");
			System.out.println("2. Просмотреть список снаряжения, доступного к прокату.");
			System.out.println("3. Просмотреть список снаряжения, взятого в прокат.");
			System.out.println("4. Взять конкретный элемент снаряжения в прокат.");

			switch (sc.nextLine()) {
			case "1":

				break;

			default:
				break;
			}
		}
	}
}
