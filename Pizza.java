import java.util.ArrayList;
import java.util.Objects;

public class Pizza {

    String[] toppings = new String[10];
    String self = "A Pizza with ";
    int price = 14;

    public String toString() {
        if (Objects.equals(toppings[0], null)) {
            return "A Plain Cheese Pizza, costing 14 dollars.";
        }else {
            String x = " costing ";
            String y = " dollars.";
            return (self + x + price + y);
        }
    }
    public int hashCode() {
        return price;
    }

    Pizza(String[] topping, int amount) {
        int x = 0;
        for (String string : topping) {
            this.self += (string + ", ");
            this.toppings[x] = string;
            x += 1;
        }
        this.price += (2 * amount);
    }
}
