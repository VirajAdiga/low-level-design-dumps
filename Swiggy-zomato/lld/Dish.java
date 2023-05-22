package lld;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private Cuisine cuisine;
    private String description;
    private double price;
    private List<String> dishImages;
    private List<DishAddOn> addons;

    public Dish(String name, Cuisine cuisine, double price) {
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
        this.dishImages = new ArrayList<>();
        this.addons = new ArrayList<>();
    }

    public void addAddOn(DishAddOn addOn) {
        addons.add(addOn);
    }

    public double getPrice() { 
        double totalPrice = price;
        for (DishAddOn addOn : addons)
            totalPrice += addOn.getPrice();
        return totalPrice; 
    }

    public String getDescription() { return description; }

    public String getDishName() { return name; }

    public Cuisine getCuisine() { return cuisine; }
}
