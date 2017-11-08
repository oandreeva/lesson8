package by.pvt.lesson8;

public class IdGenerator {

	private static int ID = 0;

	public static int generate() {
		return ++ID;

	}
}
