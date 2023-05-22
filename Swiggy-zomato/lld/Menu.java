package lld;

import java.util.HashMap;
import java.util.List;

public class Menu {
    private List<Dish> dishes;

    public Menu(HashMap<Dish, Integer> dishes) {
        this.dishes = (List<Dish>) dishes;
    }
}

