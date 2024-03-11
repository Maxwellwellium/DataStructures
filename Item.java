import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
    private String name;
    private double price;
    private int bulk;
    private double discount;


    // getters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getBulk() {return bulk;}
    public double getDiscount() {
        BigDecimal bd = BigDecimal.valueOf(((this.price-this.discount)*this.bulk));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    // setters
    public void setName(String name) {
        this.name = name;
        System.out.println("the name is now: " + this.name);
    }
    public void setPrice(String name) {
        switch(name) {
            case "Steak":
                this.price = 12.99;
                break;
            case "Corned Beef":
            case "Turkey":
                this.price = 10.99;
                break;
            case "Ham":
            case "Fruit Salad":
                this.price = 7.99;
                break;
            case "Apple Pie":
            case "Pumpkin Pie":
            case "Cherry Pie":
                this.price = 6.99;
                break;
            case "Chicken Broth":
            case "Potatoes":
            case "Sweet Potatoes":
                this.price = 5.99;
                break;
            case "Squash":
            case "Carrots":
                this.price = 4.99;
                break;
            case "Green Beans":
            case "Beets":
            case "Cheese":
                this.price = 3.99;
                break;
            case "Cranberries":
            case "Gravy Mix":
            case "Macaroni":
                this.price = 2.99;
                break;
            case "Cornbread Mix":
            case "Biscuits":
            case "Rot":
                this.price = 1.99;
        }
        this.discount = switch ((int) this.price) {
            case 1, 2 -> 0.5;
            case 3, 4 -> 1.5;
            case 5, 6, 7 -> 2;
            case 10 -> 3;
            case 12 -> 4;
            default -> 0;
        };

        System.out.println("the price is now: " + this.price);
        System.out.println("the discount is now: " + this.discount);
    }
    public void setBulk(int bulk) {
        this.bulk = bulk;

        System.out.println("the bulk order is now: " + this.bulk);
    }
}
