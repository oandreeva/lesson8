package by.pvt.lesson8.units;

import java.util.Date;

public class Equipment {

	private Category category;
	private String title;
	private double price;
	private boolean rented = false;
	private Date startDate;
	private Date endDate;
	private int hours;

	public Equipment(Category category, String title, double price) {
		this.category = category;
		this.title = title;
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public double getPrice() {
		return price;
	}

	public void start() {
		startDate = new Date();
		rented = true;
	}

	public void stop() {
		endDate = new Date();
		rented = false;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		Equipment other = (Equipment) obj;
		if (category != other.category)
			return false;
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
		return "[Category: " + category + ", Title: " + title + ", Price: " + price + ", Rented: " + rented + "]";
	}
}
