import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Vector;

public class TestWedding extends JFrame {
    Wedding newWedding = new Wedding();
    public TestWedding() {
        // make new instance of wedding class
        //Wedding newWedding = new Wedding();
        Couple newCouple = newWedding.getCouple();
        Person newGroom = newCouple.getGroom();
        Person newBride = newCouple.getBride();

        // set parameters of GUI
        setTitle("Person");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(360, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // labels and textfields for couple's names
        JTextField firstNameGroom = new JTextField();
        JTextField lastNameGroom = new JTextField();
        JTextField firstNameBride = new JTextField();
        JTextField lastNameBride = new JTextField();
        JLabel fNGText = new JLabel("Enter the Groom's first name.", SwingConstants.CENTER);
        JLabel lNGText = new JLabel("Enter the Groom's last name.", SwingConstants.CENTER);
        JLabel fNBText = new JLabel("Enter the Bride's first name.", SwingConstants.CENTER);
        JLabel lNBText = new JLabel("Enter the Bride's last name.", SwingConstants.CENTER);
        JPanel couple = new JPanel(new GridLayout(4, 2));
        couple.add(fNGText);
        couple.add(lNGText);
        couple.add(firstNameGroom);
        couple.add(lastNameGroom);
        couple.add(fNBText);
        couple.add(lNBText);
        couple.add(firstNameBride);
        couple.add(lastNameBride);

        // labels and textfields for wedding information
        JLabel dText = new JLabel("Enter the Wedding's Date in format: YYYY-MM-DD.", SwingConstants.CENTER);
        JTextField date = new JTextField();
        JLabel lText = new JLabel("Enter the Wedding's Location.", SwingConstants.CENTER);
        JTextField location = new JTextField();
        JPanel info = new JPanel(new GridLayout(4, 1));
        info.add(dText);
        info.add(date);
        info.add(lText);
        info.add(location);

        JButton enterButton = new JButton("Enter Wedding Information.");
        JPanel enterPanel = new JPanel();
        enterPanel.add(enterButton);

        setLayout(new GridLayout(3, 1));
        add(couple);
        add(info);
        add(enterPanel);

        // information confirmation elements
        JRadioButton confirmYes = new JRadioButton("Yes, the information listed above is correct.", true);
        JRadioButton confirmNoCouple = new JRadioButton("No, the Groom or Bride's names are incorrect.");
        JRadioButton confirmNoInfo = new JRadioButton("No, the wedding's date or location is incorrect.");
        JButton confirmButton = new JButton("Confirm Wedding Information.");
        JPanel confirmChoose = new JPanel();
        confirmChoose.add(confirmYes);
        confirmChoose.add(confirmNoCouple);
        confirmChoose.add(confirmNoInfo);
        confirmChoose.add(confirmButton);
        JLabel weddingConfirmed = new JLabel("Congradulations, the Wedding Plans have been confirmed!", SwingConstants.CENTER);

        // action listeners
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkInputs()) {
                    System.out.println("box unfilled");
                    JOptionPane.showMessageDialog(null, "All information must be filled in to continue!");
                } else {
                    getContentPane().removeAll();
                    JLabel confirmAll = new JLabel("<html> The Groom's name is " + newGroom.getFirstName() + " " + newGroom.getLastName() + "<br>" +
                            "The Bride's name is " + newBride.getFirstName() + " " + newBride.getLastName() + "<br>" +
                            "The Wedding will take place at " + newWedding.getLocation() + " on " + newWedding.getDate() + "<br>" +
                            "<br>" + "<br>" + "Is this information correct?" + "<html>", SwingConstants.CENTER);
                    add(confirmAll);
                    add(confirmChoose);
                    revalidate();
                    repaint();
                }
            }
        });

        confirmYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmNoCouple.setSelected(false);
                confirmNoInfo.setSelected(false);
            }});
        confirmNoCouple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmYes.setSelected(false);
            }});
        confirmNoInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmYes.setSelected(false);
            }});

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                if (confirmYes.isSelected()) {
                    add(weddingConfirmed);
                }else {
                    if (confirmNoCouple.isSelected()) {
                        add(couple);
                        add(enterPanel);
                        firstNameGroom.setText(null);
                        newGroom.setFirstName(null);
                        lastNameGroom.setText(null);
                        newGroom.setLastName(null);
                        firstNameBride.setText(null);
                        newBride.setFirstName(null);
                        lastNameBride.setText(null);
                        newBride.setLastName(null);
                    };
                    if (confirmNoInfo.isSelected()) {
                        add(info);
                        add(enterPanel);
                        date.setText(null);
                        location.setText(null);
                        newWedding.setDate(null);
                        newWedding.setLocation(null);
                    };
                };
                revalidate();
                repaint();
            };
        });

        firstNameGroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGroom.setFirstName(firstNameGroom.getText());
            }});
        lastNameGroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGroom.setLastName(lastNameGroom.getText());
            }});
        firstNameBride.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newBride.setFirstName(firstNameBride.getText());
            }});
        lastNameBride.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newBride.setLastName(lastNameBride.getText());
            }});
        date.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newWedding.setDate(LocalDate.parse(date.getText()));
            }});
        location.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newWedding.setLocation(location.getText());
            }});
    }
    public boolean checkInputs() {
        // checks if any of the boxes haven't been filled out and prevents user from continuing
        LocalDate date = newWedding.getDate();
        String location = newWedding.getLocation();
        Couple newCouple = newWedding.getCouple();
        Person newGroom = newCouple.getGroom();
        Person newBride = newCouple.getBride();
        String firstNameGroom = newGroom.getFirstName();
        String lastNameGroom = newGroom.getLastName();
        String firstNameBride = newBride.getFirstName();
        String lastNameBride = newBride.getLastName();
        Vector check = new Vector(6);
        check.add(date);
        check.add(location);
        check.add(firstNameGroom);
        check.add(lastNameGroom);
        check.add(firstNameBride);
        check.add(lastNameBride);
        int i;
        for (i = 0; i < check.size(); i++) {
            if (check.get(i) == null){
                return true;
            }
        }
        return false;
    };

    public static void main(String[] args) {
        TestWedding wedding = new TestWedding();
        wedding.setVisible(true);
    }
}
