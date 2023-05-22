import java.util.List;
import java.util.Map;

abstract class Product {
    abstract float getPrice();
}

class Water extends Product {
    String name;
    float getPrice() {
        return 1.0F;
    }
}

class Coke extends Product {
    String name;
    float getPrice() {
        return 2.0F;
    }
}

abstract class Payment {
    abstract float checkOut(Product productId);
}

class CreditCardPayment extends Payment {
    float checkOut(Product productId) {
        return (float) (productId.getPrice() * 0.1);
    }
}

class cashPayment extends Payment  {
    float checkOut(Product productId) {
        return (float) (productId.getPrice() * 0.0);
    }
}
class VendingMachine {
    Map<String, Product> slots;

    int capacity;
    int pay;

    VendingMachine(int capacity) {
        this.capacity = capacity;
    }

    boolean addProduct(String productId, Product product) {
        if(this.capacity >= slots.size()) {
            return false;
        }
        slots.put(productId, product);
        return true;
    }

    Product order(String product) {
        return slots.getOrDefault(product, null);
    }

    float checkout(List<Product> cart, Payment payment) {
        int totalAmount = 0;
        for(Product product : cart) {
            totalAmount += payment.checkOut(product);
        }
        return totalAmount;
    }
}

class Customer {
    VendingMachine vendingMachine;
    List<Product> cart;

    public Customer(VendingMachine vm) {
        this.vendingMachine = vm;
    }

    public boolean select(String productId) {
        Product product = vendingMachine.order(productId);
        if(product != null) {
            cart.add(product);
            return true;
        }
        return false;
    }

    public float checkout(Payment payment) {
        return vendingMachine.checkout(cart, payment);
    }
}

public class Main {
    public static void main(String[] args) {
        Water w1 = new Water();
        Water w2 = new Water();
        Coke c1 = new Coke();
        Coke c2 = new Coke();

        VendingMachine vm = new VendingMachine(5);
        vm.addProduct("A1", w1);
        vm.addProduct("A2", w1);
        vm.addProduct("A3", c1);
        vm.addProduct("A4", c2);


        Customer customer = new Customer(vm);
        customer.select("A1");
        customer.select("A2");

        Payment card = new CreditCardPayment();
        customer.checkout(card);
    }
}
