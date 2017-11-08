package by.pvt.lesson8.units;

public class Helm extends Accessory{

	public Helm(String title, double price) {
		super(title, price);
		
	}

	@Override
	public String toString() {
		return "Helm" + super.toString();
	}
}
