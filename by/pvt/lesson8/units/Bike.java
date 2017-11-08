package by.pvt.lesson8.units;

public class Bike extends Equipment {

	public Bike(Category category, String title, double price) {
		super(category, title, price);

	}

	@Override
	public String toString() {
		return "Bike" + super.toString();
	}

}
