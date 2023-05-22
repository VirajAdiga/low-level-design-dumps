package lld;

import java.util.ArrayList;

public class DishAddOn {
	private String name;
	private String description;
	private double price;
	private boolean isAvail;
	private ArrayList<String> images;

	public DishAddOn(String pName, double pPrice) {
		name = pName;
		price = pPrice;
	}

	public double getPrice() {
		return price;
	}
}

