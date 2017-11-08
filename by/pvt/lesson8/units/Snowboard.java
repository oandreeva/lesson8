package by.pvt.lesson8.units;

public class Snowboard extends Equipment {

	public Snowboard(Category category, String title, double price) {
		super(category, title, price);
		
	}
	@Override
	public String toString() {
		return "Snowboard" + super.toString();
	}
}
