import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class Main extends JFrame{
    static ShoppingCart cart = new ShoppingCart();
    public Main() {
        // set parameters of GUI
        setTitle("Scrhodingy's Grocer Store");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(440, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        String[] itemStock = {"Steak", "Corned Beef", "Ham", "Chicken Broth", "Potatoes", "Sweet Potatoes", "Squash", "Carrots", "Green Beans",
        "Beets", "Cheese", "Biscuits", "Rot", "Apple Pie", "Pumpkin Pie", "Cornbread Mix", "Gravy Mix", "Cranberries", "Turkey", "Macaroni",
        "Cherry Pie", "Fruit Salad"};

        // choose random 14 of the grocery items to sell
        ArrayList<String> itemsToday = new ArrayList<String>(14);
        int itemsChosen = 0;
        String[] itemStockTemp = itemStock.clone();
        while (itemsChosen < 14) {
            int rnd = new Random().nextInt(itemStockTemp.length);

            if (!itemsToday.contains(itemStockTemp[rnd])) {
                itemsToday.add(itemStockTemp[rnd]);
                itemsChosen += 1;
            }
        }
        //set their sales to different amounts
        int[] sales = {2, 3, 4, 5};
        ArrayList<Item> itemsSelling = new ArrayList<>(14);
        for (String string : itemsToday) {
            int rnd = new Random().nextInt(sales.length);
            Item x = new Item();
            x.setName(string);
            x.setPrice(string);
            x.setBulk(sales[rnd]);
            itemsSelling.add(x);
        }
        System.out.println("the list: " + itemsToday);

        JPanel visible = new JPanel(new GridLayout(2, 1));
        JPanel deals = getjPanel(itemsSelling);
        JPanel order = getjPanel2(itemsSelling);

        JPanel cartmode = new JPanel(new GridLayout(3, 2));
        JPanel cartItems = new JPanel(new GridLayout(8, 2));
        JButton vCart = new JButton("View Cart");
        JButton cartBack = new JButton("Go Back to Shopping");
        JButton cartCont = new JButton("Head to Checkout");

        cartmode.add(cartItems);
        cartmode.add(cartBack);
        cartmode.add(cartCont);
        order.add(vCart);
        visible.add(deals);
        visible.add(order);
        add(visible);
        // action listeners
        vCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ItemOrder item : cart.getCart()) {
                    int amount = item.getAmount();
                    String name = item.getItem().getName();
                    double price = item.getItem().getPrice();
                    int bulk = item.getItem().getBulk();
                    double discount = item.getItem().getDiscount();

                    int discounts = Math.floorDiv(amount, bulk);
                    int remainder = amount % bulk;
                    double priceItemTotal = (discounts * discount) + (remainder * price);
                    cart.addCartTotal(priceItemTotal);
                    BigDecimal bd = BigDecimal.valueOf(priceItemTotal);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    JLabel label = new JLabel(amount +" "+ name + " --------------- (" + bd + ")", SwingConstants.CENTER);
                    cartItems.add(label);

                }
                double x = cart.getCartTotal();
                JLabel label = new JLabel("Total Price --------------- (" + x + ")", SwingConstants.CENTER);
                cartItems.add(label);
                getContentPane().removeAll();
                add(cartmode);
                revalidate();
                repaint();
            }
        });
        cartBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                cartItems.removeAll();
                cart.resetCartTotal();
                add(visible);
                revalidate();
                repaint();
            }
        });
        cartCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(2, 1));
                double x = cart.getCartTotal();
                JLabel label  = new JLabel("your online order for " + x + " has been placed!", SwingConstants.CENTER);
                panel.add(cartItems);
                panel.add(label);
                getContentPane().removeAll();
                add(panel);
                revalidate();
                repaint();
            }
        });
    }

    private static JPanel getjPanel(ArrayList<Item> itemsSelling) {
        JPanel deals = new JPanel(new GridLayout(7, 2));
        for (Item item : itemsSelling) {
            String x = item.getName();
            double y = item.getPrice();
            int z = item.getBulk();
            double w = item.getDiscount();
            JLabel label = new JLabel(x+ " at " +y+ " (" +z+ " for " +w+ ")" , SwingConstants.CENTER);
            deals.add(label);
        }
        return deals;
    }
    private static JPanel getjPanel2(ArrayList<Item> itemsSelling) {
        JPanel order = new JPanel(new GridLayout(8, 2));

        for (Item item : itemsSelling) {
            JPanel panel = new JPanel(new GridLayout(1, 2));
            ItemOrder itemOrder = new ItemOrder(item, 0);
            JLabel label = new JLabel(item.getName(), SwingConstants.CENTER);
            SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 1000, 1);
            JSpinner amount = new JSpinner(model);
            amount.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    itemOrder.setAmount(model.getNumber().intValue());
                    if (!(model.getNumber().intValue() == 0)) {
                        cart.addCart(itemOrder);
                    }else{
                        cart.removeCart(itemOrder);
                    }
                }
            });
            panel.add(label);
            panel.add(amount);
            order.add(panel);
        }
        return order;
    }

    public static void main(String[] args){
        Main main = new Main();
        main.setVisible(true);
    }
}