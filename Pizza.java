import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Pizza extends JFrame implements ActionListener {
    final int FRAME_WIDTH = 600;
    final int FRAME_HEIGHT = 700;
    JLabel displayTotal = new JLabel("Select Size and enter amount", JLabel.CENTER);
    float priceTotal = 0.0F, priceCheese = 0.0F, pricePepperoni = 0.0F, priceSupreme = 0.0F, priceMeatLovers = 0.0F, priceVegetable = 0.0F;
    public Pizza() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayTotal.setFont(new Font("Arial", Font.PLAIN, 15));
        JButton place = new JButton("Place order");
        if (priceTotal != 0) {
            place.setVisible(false);
        }
        place.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (priceTotal != 0.0F) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Total Order is " + priceTotal + " would you like to place your order?",
                            "Order Confirmation", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION)
                        JOptionPane.showMessageDialog(null, "Order placed! Enjoy your BigY pizza.");
                    else
                        JOptionPane.showMessageDialog(null, "Order Canceled!");
                }else {
                    JOptionPane.showMessageDialog(null, "Order must be over $0.00! Make sure a size and amount have been entered");
                }
            }
        });

        JLabel bigtext = new JLabel("BigY Store Pizza Order", JLabel.CENTER);
        bigtext.setFont(new Font("Arial", Font.BOLD, 50));
        JLabel explanation = new JLabel("<html><br><br><br><br><br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Select Pizza " +
                "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp " +
                " Amount " +
                "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp " +
                "Pizza Size " +
                "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp " +
                "Customize Toppings", JLabel.LEFT);
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(3, 1));
        setLayout(new GridLayout(2, 1));
        JPanel pizzaChoose = new JPanel();
        pizzaChoose.setLayout(new GridLayout(5, 1));
        JPanel order = new JPanel();
        order.setLayout(new GridLayout(1, 2));

        String[] pizzaTypes = new String[] {"Cheese", "Pepperoni", "Supreme", "MeatLovers", "Vegetable"};
        for (java.lang.String String : pizzaTypes) {
            Vector Pizza = createPizza(String);
            JPanel z = (JPanel) Pizza.getFirst();
            pizzaChoose.add(z);
        }
        order.add(displayTotal);
        order.add(place);
        info.add(bigtext);
        info.add(order);
        info.add(explanation);
        add(info);
        add(pizzaChoose);
    }

    String updatePrice(String PizzaType, float pizzaPrice, short[] amountPizza) {
        switch (PizzaType) {
            case "Cheese" -> {
                priceCheese = pizzaPrice;
                System.out.println("Cheese is "+priceCheese);}
            case "Pepperoni" -> {
                pricePepperoni = pizzaPrice;
                System.out.println("pepperoni is "+pricePepperoni);}
            case "Supreme" -> {
                priceSupreme = pizzaPrice;
                System.out.println("supreme is "+priceSupreme);}
            case "MeatLovers" -> {
                priceMeatLovers = pizzaPrice;
                System.out.println("meatlovers is "+priceMeatLovers);}
            case "Vegetable" -> {
                priceVegetable = pizzaPrice;
                System.out.println("veggie is "+priceVegetable);}
        }
        priceTotal = priceCheese + pricePepperoni + priceSupreme + priceMeatLovers + priceVegetable;
        System.out.println("total is "+priceTotal);
        return "<html> Your Total Order is: $" + priceTotal + "<br>" +
                "Cheese Pizza &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp= &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp " + priceCheese + "<br>" +
                "Pepperoni Pizza &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp= &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp " + pricePepperoni + "<br>" +
                "Supreme Pizza &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp= &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp " + priceSupreme + "<br>" +
                "Meat Lover's Pizza &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp= &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp " + priceMeatLovers + "<br>" +
                "Vegetable Pizza &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp= &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp " + priceVegetable + "<br>" +
                "<html>";
    }

    byte toppingLimit(JCheckBox jCheckBox, byte limit) {
        System.out.println(jCheckBox.getText() +" is "+ jCheckBox.isSelected());
        if (jCheckBox.isSelected()) {
            limit += 1;
        }else if (!jCheckBox.isSelected()) {
            limit -= 1;
        }
        //System.out.println(limit);
        return limit;
    }

    float calcTotal(short[] amountPizza, short[] sizeChosen, byte[] limit, float cheeseOffset) {
        if (limit[0] == 3) {
            if (cheeseOffset == 0.5F) {
                float totalAmount = (amountPizza[0] * (sizeChosen[0] + 1));
                System.out.println("Your Order is: " + totalAmount);
                return totalAmount;
            }
            float totalAmount = (float) (amountPizza[0] * (sizeChosen[0] + (1.25) - cheeseOffset));
            System.out.println("Your Order is: " + totalAmount);
            return totalAmount;
        }
        float totalAmount = amountPizza[0] * (sizeChosen[0] + (limit[0] * 0.5F) - cheeseOffset);
        System.out.println("Your Order is: " + totalAmount);
        return totalAmount;
    }

    Vector createPizza(String PizzaType) {
        JLabel pizza = new JLabel(PizzaType, JLabel.CENTER);
        pizza.setFont(new Font("Arial", Font.BOLD, 13));

        final short[] amountPizza = {0};
        final short[] sizeChosen = {0};
        final byte[] limit = {0};
        final float[] cheeseOffset = {0.0F};
        final float[] pizzaTotal = {0.0F};

        // formats the text field so only 2 numbers are accepted
        final JFormattedTextField[] amount = {null};
        try  {
            MaskFormatter numberFormat = new MaskFormatter("##");
            amount[0] = new JFormattedTextField(numberFormat);
        }
        catch (ParseException ignored)  {}

        JFormattedTextField finalAmount = amount[0];
        assert amount[0] != null;

        amount[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                amountPizza[0] = (short) Integer.parseInt(finalAmount.getText());
                pizzaTotal[0] = calcTotal(amountPizza, sizeChosen, limit, cheeseOffset[0]);
                String newPrice = updatePrice(PizzaType, pizzaTotal[0], amountPizza);
                displayTotal.setText(newPrice);
                System.out.println(pizzaTotal[0]);
            }
        });

        // creates the radio buttons for choosing pizza size
        ButtonGroup size = new ButtonGroup();
        JRadioButton small = new JRadioButton("Small");
        JRadioButton medium = new JRadioButton("Medium");
        JRadioButton large = new JRadioButton("Large");
        JRadioButton superlarge = new JRadioButton("Super");

        JPanel sizepanel = new JPanel();
        sizepanel.setLayout(new GridLayout(4, 1));
        for (JRadioButton jRadioButton : Arrays.asList(small, medium, large, superlarge)) {
            size.add(jRadioButton);
            sizepanel.add(jRadioButton);
            jRadioButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Objects.equals(jRadioButton.getText(), "Small")) {
                        sizeChosen[0] = 5;
                    }else if (Objects.equals(jRadioButton.getText(), "Medium")) {
                        sizeChosen[0] = 10;
                    }else if (Objects.equals(jRadioButton.getText(), "Large")) {
                        sizeChosen[0] = 15;
                    }else {
                        sizeChosen[0] = 20;
                    }

                    System.out.println("Selected " + jRadioButton.getText() +" "+ PizzaType +" pizza.");
                    System.out.println("Price:" + sizeChosen[0]);

                    pizzaTotal[0] = calcTotal(amountPizza, sizeChosen, limit, cheeseOffset[0]);
                    String newPrice = updatePrice(PizzaType, pizzaTotal[0], amountPizza);
                    displayTotal.setText(newPrice);
                    System.out.println(pizzaTotal[0]);
                }
            });
        }

        JPanel toppingspanel = new JPanel();
        toppingspanel.setLayout(new GridLayout(3, 4));

        JCheckBox cheese = new JCheckBox("Add Cheese");
        JCheckBox pepperoni = new JCheckBox("Add Pepperoni");
        JCheckBox olives = new JCheckBox("Add Black Olives");
        JCheckBox peppers = new JCheckBox("Add Bell Peppers");
        JCheckBox onions = new JCheckBox("Add Onions");
        JCheckBox bacon = new JCheckBox("Add Bacon");
        JCheckBox ham = new JCheckBox("Add Ham");
        JCheckBox pineapple = new JCheckBox("Add Pineapple");
        JCheckBox jalapenos = new JCheckBox("Add Jalapenos");
        JCheckBox sausage = new JCheckBox("Add Sausage");


        for (JCheckBox jCheckBox : Arrays.asList(cheese, pepperoni, olives, peppers, onions, bacon, ham, pineapple, jalapenos, sausage)) {
            toppingspanel.add(jCheckBox);
            jCheckBox.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    System.out.println(jCheckBox.getText() +" is "+ jCheckBox.isSelected());
                    limit[0] = toppingLimit(jCheckBox, limit[0]);
                    System.out.println(limit[0]);

                    //accounts for extra cheese being free
                    if (cheese.isSelected()) {
                        cheeseOffset[0] = 0.5F;
                        System.out.println("cheese selected");
                    } else {
                        cheeseOffset[0] = 0.0F;
                    }

                    pizzaTotal[0] = calcTotal(amountPizza, sizeChosen, limit, cheeseOffset[0]);
                    String newPrice = updatePrice(PizzaType, pizzaTotal[0], amountPizza);
                    displayTotal.setText(newPrice);
                    System.out.println(pizzaTotal[0]);

                    // if else statement that toggles the rest of the check buttons once 3 have been chosen
                    if (limit[0] >= 3) {
                        System.out.println("success");
                        for (JCheckBox jCheckBox : Arrays.asList(cheese, pepperoni, olives, peppers, onions, bacon, ham, pineapple, jalapenos, sausage)) {
                            if (!jCheckBox.isSelected()) {
                                jCheckBox.setVisible(false);
                            }
                        }
                    }else if (limit[0] == 2){
                        for (JCheckBox jCheckBox : Arrays.asList(cheese, pepperoni, olives, peppers, onions, bacon, ham, pineapple, jalapenos, sausage)) {
                            if (!jCheckBox.isSelected()) {
                                jCheckBox.setVisible(true);
                            }
                        }
                    }
                }
            });
        }
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new GridLayout(1, 3));
        firstPanel.add(pizza);
        firstPanel.add(amount[0]);
        firstPanel.add(sizepanel);
        JPanel pizzapanel = new JPanel();
        pizzapanel.setLayout(new GridLayout(1, 1));
        pizzapanel.add(firstPanel);
        pizzapanel.add(toppingspanel);

        Vector v = new Vector(3);
        v.add(pizzapanel);
        v.add(pizzaTotal[0]);
        v.add(displayTotal);
        return v;
    }

    public static void main(String[] args) {
        Pizza test = new Pizza();
        test.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}