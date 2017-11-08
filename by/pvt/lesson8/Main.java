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
				System.out.println("� ���������� 7");
				break;
			case "0":
				System.out.println("�����");
				isExit = true;
				break;
			default:
				mainMenu();
				break;
			}
		}

	}

	private static void mainMenu() {
		System.out.println("1. ������� ������������.");
		System.out.println("2. ������� ������������ �� ������ � �������� ��������.");
		System.out.println("3. ����������� ������ ����������, ���������� � �������.");
		System.out.println("4. ����������� ������ ����������, ������� � ������.");
		System.out.println("5. ����� ���������� ������� ���������� � ������.");
		System.out.println("6. ������� ����������.");
		System.out.println("7. ������� ������ ����������, ������� �� ������� �� ������� � ����.");
		System.out.println("0. ��������� ������ ������ �������.");
	}

	private static void createUserMenu(Scanner sc, RentStation station) {
		System.out.println("������� ��� ������������:");

		String name = sc.nextLine();
		Customer customer = new Customer(IdGenerator.generate(), name);
		station.addCustomer(customer);
		currentCustomer = customer;

		System.out.println("������������ � ������ " + customer.getName() + " ������.");
	}

	public static void selectCustomerMenu(Scanner sc, RentStation station) {
		System.out.println("�������� ������������");
		station.printCustomers();
		currentCustomer = station.getCustomer(Integer.parseInt(sc.nextLine()) - 1);
	}

	public static void rentCurrent(Scanner sc, RentStation station) {
		System.out.println("�������� ���������� �� ������ ������� ������ ����������:");
		station.printEquipment();
		
		int equip = Integer.valueOf(sc.nextLine()) - 1;
		
		System.out.println("�� ����� ���-�� ����� ������ ����������?");
		
		int hours = Integer.valueOf(sc.nextLine());
		
		station.rent(currentCustomer, equip, hours);
	}
	
	public static void returnEquipment(Scanner sc, RentStation station) {
		System.out.println("�������� ���������� �� ������ ������� ������ �������:");
		station.printRentedEquipmentByCustomer(currentCustomer);
		int equip = Integer.valueOf(sc.nextLine()) - 1;
		Equipment equipment = currentCustomer.getEquipments()[equip];
		currentCustomer.delete(equipment);
		System.out.println("���������� " + equipment.toString() + " ������� ����������.");
		
	}

	private static void rentMenu(Scanner sc) {
		boolean isExit = false;
		while (!isExit) {
			System.out.println("1. ������� ������������.");
			System.out.println("2. ����������� ������ ����������, ���������� � �������.");
			System.out.println("3. ����������� ������ ����������, ������� � ������.");
			System.out.println("4. ����� ���������� ������� ���������� � ������.");

			switch (sc.nextLine()) {
			case "1":

				break;

			default:
				break;
			}
		}
	}
}
