import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestBloodData extends JFrame {

    public JPanel createComponents(BloodData bloodData) {

        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel panel1 = new JPanel(new GridLayout(2, 1));
        JPanel subpanel1 = new JPanel(new GridLayout(5, 1));
        JPanel subpanel2 = new JPanel(new GridLayout(5, 1));

        JLabel typeLabel = new JLabel("Select your Blood Type", SwingConstants.CENTER);
        JLabel rHLabel = new JLabel("Confirm rh Factor", SwingConstants.CENTER);
        JCheckBox rH = new JCheckBox("rH Factor");
        ButtonGroup types = new ButtonGroup();
        JRadioButton A = new JRadioButton("A");
        JRadioButton B = new JRadioButton("B");
        JRadioButton AB = new JRadioButton("AB");
        JRadioButton O = new JRadioButton("O", true);
        types.add(A);
        types.add(B);
        types.add(AB);
        types.add(O);
        subpanel1.add(typeLabel);
        subpanel1.add(A);
        subpanel1.add(B);
        subpanel1.add(AB);
        subpanel1.add(O);
        subpanel2.add(rHLabel);
        subpanel2.add(rH);
        panel1.add(subpanel1);
        panel1.add(subpanel2);
        JPanel panel2 = new JPanel(new GridLayout(2, 1));
        final JLabel[] info = {new JLabel("Blood Data: " + bloodData.printBlood(), SwingConstants.CENTER)};
        panel2.add(info[0]);
        panel.add(panel1);
        panel.add(panel2);

        // action listeners
        rH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData(rH.isSelected());
                info[0].setText("Patient Information" + bloodData.printBlood());
                revalidate();
                repaint();
            }
        });
        A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData("A");
                info[0].setText("Patient Information" + bloodData.printBlood());
                revalidate();
                repaint();
            }
        });
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData("B");
                info[0].setText("Patient Information" + bloodData.printBlood());
                revalidate();
                repaint();
            }
        });
        AB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData("AB");
                info[0].setText("Patient Information" + bloodData.printBlood());
                revalidate();
                repaint();
            }
        });
        O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData("O");
                info[0].setText("Patient Information" + bloodData.printBlood());
                revalidate();
                repaint();
            }
        });
        return panel;
    }
    public TestBloodData() {
        // set parameters of GUI
        setTitle("Scrhodingy's Blood Facility");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        new GridLayout(1, 1);

        JPanel superpanel = new JPanel(new GridLayout(1, 3));
        BloodData bloodData1 = new BloodData();
        BloodData bloodData2 = new BloodData();
        JPanel panel = createComponents(bloodData1);
        final JLabel info = new JLabel("Blood Data: " + bloodData2.printBlood(), SwingConstants.CENTER);

        superpanel.add(panel);
        superpanel.add(info);
        JButton confirm = new JButton("Confirm blood type");
        superpanel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData2.setBd(bloodData1.getBd());
                info.setText("Blood Data: " + bloodData2.printBlood());
                revalidate();
                repaint();
            }
        });


        add(superpanel);
        revalidate();
        repaint();
    }


    public static void main(String[] args) {
        TestBloodData main = new TestBloodData();
        main.setVisible(true);
    }
}