package by.pvt.lesson8.units;

import java.util.Date;

public class Accessory {

	private String title;
	private double price;
	private boolean rented = false;
	private Date startDate;
	private Date endDate;
	private int hours;

	public Accessory(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public void start() {
		startDate = new Date();
	}

	public void stop() {
		endDate = new Date();
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accessory other = (Accessory) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[Title: " + title + ", Price: " + price + ", Rented: " + rented + "]";
	}
}
