import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Objects;

public class DemoPizza extends JFrame {
    public DemoPizza() {
        // set parameters of GUI
        setTitle("Scrhodingy's Pizza");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        ArrayList<String> toppingsTemp = new ArrayList<String>();
        ArrayList<Object> pizzaList = new ArrayList<>();
        final int[] limit = {0};

        JPanel All = new JPanel(new GridLayout(2, 1));
        JPanel tVisible = new JPanel(new GridLayout(3, 1));
        JPanel dVisible = new JPanel(new GridLayout(4, 1));

        JLabel label = new JLabel("Enter the toppings you wish to add, to remove a topping, type it again.", SwingConstants.CENTER);
        JTextField enter = new JTextField("");
        JPanel tpanel = new JPanel(new GridLayout(3, 1));

        tVisible.add(label);
        tVisible.add(enter);
        tVisible.add(tpanel);

        JCheckBox delivery = new JCheckBox("Make Delivery (leave unchecked for Pick-Up).");
        JButton complete = new JButton("Complete Current Pizza Order");

        dVisible.add(delivery);
        dVisible.add(complete);

        JLabel tAmount = new JLabel("", SwingConstants.CENTER);
        JLabel dLabel = new JLabel("", SwingConstants.CENTER);
        JTextField dEnter = new JTextField("");
        JLabel noAddress = new JLabel("No Address Given, please enter an address or deselect the Delivery Option.", SwingConstants.CENTER);

        JPanel order = new JPanel(new GridLayout(10, 2));
        JLabel oLabel = new JLabel("Itemized Order:", SwingConstants.CENTER);
        JButton start = new JButton("Begin Another Pizza Order");
        JButton end = new JButton("Submit Order");
        order.add(oLabel);

        All.add(tVisible);
        All.add(dVisible);
        add(All);

        start.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
                toppingsTemp.clear();
                limit[0] = 0;
                remove(order);
                add(All);
                revalidate();
                repaint();
            }
        }));

        end.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
                toppingsTemp.clear();

                JPanel panel = new JPanel(new GridLayout(15, 1));
                JLabel label = new JLabel("Itemized Receipt", SwingConstants.CENTER);
                panel.add(label);

                int z = 0;
                for (Object pizza : pizzaList) {
                    JLabel x = new JLabel(pizza.toString(), SwingConstants.CENTER);
                    panel.add(x);
                    z += pizza.hashCode();
                }
                JLabel total = new JLabel("Total Price: " + z, SwingConstants.CENTER);
                panel.add(total);
                remove(order);
                add(panel);
                revalidate();
                repaint();
            }
        }));

        delivery.addItemListener((new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(delivery.isSelected());
                dLabel.setText("Enter Delivery Address");
                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(dLabel);
                panel.add(dEnter);
                dVisible.removeAll();
                dVisible.add(delivery);
                dVisible.add(panel);
                revalidate();
                repaint();
                if (!delivery.isSelected()) {
                    dVisible.removeAll();
                    dVisible.add(delivery);
                    revalidate();
                    repaint();
                }
                if (dEnter.getText() != null || !Objects.equals(dEnter.getText(), "")) {
                    dVisible.add(complete);
                    revalidate();
                    repaint();
                }
            }
        }));

                complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] toppings = toppingsTemp.toArray(new String[0]);
                System.out.println("clicked");
                dVisible.remove(noAddress);
                revalidate();
                repaint();
                if (delivery.isSelected()) {
                    if(Objects.equals(dEnter.getText(), "")) {
                        dVisible.add(noAddress);
                        revalidate();
                        repaint();
                        System.out.println("No Address Given, please enter an address or deselect the Delivery Option.");
                    }else{
                        DeliveryPizza pizza = new DeliveryPizza(toppings, limit[0], dEnter.getText());
                        pizza.addFee();
                        pizzaList.add(pizza);
                        JLabel label = new JLabel(pizza.toString(), SwingConstants.CENTER);
                        remove(All);
                        order.add(label);
                        order.add(start);
                        order.add(end);
                        add(order);
                        revalidate();
                        repaint();
                        System.out.println("process complete");
                    }
                }else{
                    Pizza pizza = new Pizza(toppings, limit[0]);
                    pizzaList.add(pizza);
                    JLabel label = new JLabel(pizza.toString(), SwingConstants.CENTER);
                    remove(All);
                    order.add(label);
                    order.add(start);
                    order.add(end);
                    add(order);
                    revalidate();
                    repaint();
                    System.out.println("process complete");
                }

            }
        });
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tpanel.removeAll();
                if ((!Objects.equals(enter.getText(), "") && (!Objects.equals(enter.getText(), " ")))) {
                    if (toppingsTemp.contains(enter.getText())) {
                        toppingsTemp.remove(enter.getText());
                        limit[0] -= 1;
                        System.out.println(Integer.toString(limit[0]) + toppingsTemp);
                    }else{
                        if (limit[0] < 10) {
                            toppingsTemp.add(enter.getText());
                            limit[0] += 1;
                            System.out.println(Integer.toString(limit[0]) + toppingsTemp);
                        }
                    }
                    if (limit[0] < 10) {
                        tAmount.setText("Your Pizza has " + Integer.toString(limit[0]) + "/10 toppings so far.");
                    }else{
                        tAmount.setText("Your Pizza has 10/10 toppings! Remove some before adding more.");
                    }
                }
                if (limit[0] != 0) {
                    JLabel tList = new JLabel(String.valueOf(toppingsTemp), SwingConstants.CENTER);
                    tpanel.add(tList);
                }else{
                    JLabel tList = new JLabel("Plain Cheese Pizza, no extra Toppings.", SwingConstants.CENTER);
                    tpanel.add(tList);
                }
                tpanel.add(tAmount);
                tVisible.removeAll();
                tVisible.add(label);
                tVisible.add(enter);
                tVisible.add(tpanel);
                tVisible.revalidate();
                tVisible.repaint();
            }
        });

    }
    public static void main(String[] args) {
        DemoPizza main = new DemoPizza();
        main.setVisible(true);
    }
}