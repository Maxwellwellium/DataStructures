import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemOrder> cart = new ArrayList<>(14);
    private double cartTotal;

    // getters
    public ArrayList<ItemOrder> getCart() {
        return cart;
    }
    public double getCartTotal() {
        BigDecimal bd = BigDecimal.valueOf(this.cartTotal * 1.065);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // setters
    public void addCart(ItemOrder item) {
        if (!(cart.contains(item))) {
            cart.add(item);
        }
        System.out.println("the cart is now: " + this.cart);
    }
    public void removeCart(ItemOrder item) {
        cart.remove(item);
        System.out.println("the cart is now: " + this.cart);
    }
    public void addCartTotal(double itemprice) {
        this.cartTotal += itemprice;
        System.out.println("the cart total is now: " + this.cartTotal);
    }
    public void resetCartTotal() {
        this.cartTotal = 0;
        System.out.println("the cart total is now: " + this.cartTotal);
    }
}
