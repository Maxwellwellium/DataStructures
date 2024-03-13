import java.util.Objects;

public class DeliveryPizza extends Pizza{
    private String address;

    DeliveryPizza(String[] topping, int amount, String address) {
        super(topping, amount);
        this.address = address;
    }

    public String toString() {
        if (Objects.equals(toppings[0], null)) {
            return "A Plain Cheese Pizza, costing 19 dollars.";
        }else {
            String x = " costing ";
            String y = " dollars, to be delivered to ";
            return super.self + x + (price + y + this.address);
        }
    }

    public void addFee() {
        if (this.price < 18) {
            this.price += 5;
        }else{
            this.price += 3;
        }
    }
}
