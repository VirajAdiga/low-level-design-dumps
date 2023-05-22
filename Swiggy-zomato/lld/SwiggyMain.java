package lld;

import java.util.HashMap;

public class SwiggyMain {
    public static void main(String[] args) {
        // Chinese lld.Restaurant
        RestaurantOwner owner1 = new RestaurantOwner("owner1");
        Restaurant chineseRest = new Restaurant("chinese vala", owner1, new Location(1, 2));
        Dish noodles = new Dish("noodles", Cuisine.CHINESE, 200);
        noodles.addAddOn(new DishAddOn("premium sauce", 20));
        Dish fried_rice = new Dish("fried rice", Cuisine.CHINESE, 180);
        Dish spring_rolls = new Dish("spring rolls", Cuisine.CHINESE, 120);
        Menu chinese_menu = new Menu(new HashMap<Dish, Integer>() {{
            put(noodles, 1);
            put(fried_rice, 1);
            put(spring_rolls, 1);
        }});
        chineseRest.addMenu(chinese_menu);

        // South Indian lld.Restaurant
        RestaurantOwner owner2 = new RestaurantOwner("owner2");
        Restaurant southIndianRest = new Restaurant("south indian food", owner2, new Location(2, 3));
        Dish idli = new Dish("idli", Cuisine.SOUTH_INDIAN, 200);
        Dish dosa = new Dish("dosa", Cuisine.SOUTH_INDIAN, 180);
        Dish uthappam = new Dish("uthappam", Cuisine.SOUTH_INDIAN, 120);
        Menu south_indian_menu = new Menu(new HashMap<Dish, Integer>() {{
            put(idli, 1);
            put(dosa, 1);
            put(uthappam, 1);
        }});
        southIndianRest.addMenu(south_indian_menu);

        // Note that restaurant owners can exist without restaurants, we have used aggregation relationship
        // This can lead to owners being present with no restaurants and thus not added in restaurant manager
        // This is how we have designed and we should know consequences of the way we have structured.

        RestaurantMgr restaurantMgr = RestaurantMgr.getRestaurantMgr();
        restaurantMgr.addRestaurant("chinese vala", chineseRest);
        restaurantMgr.addRestaurant("south indian food", southIndianRest);

        //////////////////////////////////////////////////////////////////////////////////////////////

        DeliveryPartner alpha = new DeliveryPartner("alpha");
        DeliveryPartner beta = new DeliveryPartner("beta");
        DeliveryPartner gamma = new DeliveryPartner("gamma");

        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getDeliveryPartnerMgr();
        deliveryPartnerMgr.addDeliveryPartner("alpha", alpha);
        deliveryPartnerMgr.addDeliveryPartner("beta", beta);
        deliveryPartnerMgr.addDeliveryPartner("gamma", gamma);

        //////////////////////////////////////////////////////////////////////////////////////////////

        User keerti = new User("keerti", new Location(10, 11));
        User gaurav = new User("gaurav", new Location(13, 14));
        User yogita = new User("yogita", new Location(15, 16));
        // users can exist without usermgr as well. That's why it is an aggregation relationship

        UserMgr userMgr = UserMgr.getUserMgr();
        userMgr.addUser("keerti", keerti);
        userMgr.addUser("gaurav", gaurav);
        userMgr.addUser("yogita", yogita);

        //////////////////////////////////////////////////////////////////////////////////////////////

        // I am passing same dish object that was created by res, for Java folks - it should be different dish object
    }
}