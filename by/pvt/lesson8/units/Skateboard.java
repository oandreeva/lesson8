package by.pvt.lesson8.units;

public class Skateboard extends Equipment {

	public Skateboard(Category category, String title, double price) {
		super(category, title, price);
		
	}

	@Override
	public String toString() {
		return "Skateboard" + super.toString();
	}
}
