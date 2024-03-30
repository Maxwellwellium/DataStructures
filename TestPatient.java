import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestPatient extends JFrame {
    public JPanel createComponents(BloodData bloodData, Patient patient, JLabel info) {

        JPanel panel = new JPanel(new GridLayout(1, 1));
        JPanel panel1 = new JPanel(new GridLayout(2, 1));
        JPanel subpanel1 = new JPanel(new GridLayout(5, 1));
        JPanel subpanel2 = new JPanel(new GridLayout(2, 1));

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
        panel.add(panel1);

        // action listeners
        rH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData(rH.isSelected());
                info.setText("<html> Patient Data:       Blood Data: " + patient.bd.printBlood() +
                        "<br> Patient Age: " + patient.getAge() + "       Patient ID Number: " + patient.getId());
                revalidate();
                repaint();
            }
        });
        A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData("A");
                info.setText("<html> Patient Data:       Blood Data: " + patient.bd.printBlood() +
                        "<br> Patient Age: " + patient.getAge() + "       Patient ID Number: " + patient.getId());
                revalidate();
                repaint();
            }
        });
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData("B");
                info.setText("<html> Patient Data:       Blood Data: " + patient.bd.printBlood() +
                        "<br> Patient Age: " + patient.getAge() + "       Patient ID Number: " + patient.getId());
                revalidate();
                repaint();
            }
        });
        AB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData("AB");
                info.setText("<html> Patient Data:       Blood Data: " + patient.bd.printBlood() +
                        "<br> Patient Age: " + patient.getAge() + "       Patient ID Number: " + patient.getId());
                revalidate();
                repaint();
            }
        });
        O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodData.UpdateBloodData("O");
                info.setText("<html> Patient Data:       Blood Data: " + patient.bd.printBlood() +
                        "<br> Patient Age: " + patient.getAge() + "       Patient ID Number: " + patient.getId());
                revalidate();
                repaint();
            }
        });
        return panel;
    }
    public JPanel createComponents(Patient patient, boolean blood) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel patientpanel = new JPanel(new GridLayout(5, 1));

        JLabel info = new JLabel("Enter Patient Data", SwingConstants.CENTER);
        patient.bd = new BloodData();
        if (blood) {
            JPanel panelBlood = createComponents(patient.bd, patient, info);
            panel.add(panelBlood);
        }
        


        JPanel agePanel = new JPanel(new GridLayout(2, 1));
        JLabel ageLabel = new JLabel("Select Your Age", SwingConstants.CENTER);
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100, 1);
        JSpinner age = new JSpinner(model);
        agePanel.add(ageLabel);
        agePanel.add(age);
        patientpanel.add(agePanel);
        age.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                patient.setAge(model.getNumber().intValue());
                info.setText("<html> Patient Data:       Blood Data: " + patient.bd.printBlood() +
                        "<br> Patient Age: " + patient.getAge() + "       Patient ID Number: " + patient.getId());
                revalidate();
                repaint();
            }
        });

        JPanel IDPanel = new JPanel(new GridLayout(2, 1));
        JLabel IDLabel = new JLabel("Enter your ID number", SwingConstants.CENTER);
        SpinnerNumberModel IDmodel = new SpinnerNumberModel(0, 0, 99999, 1);
        JSpinner ID = new JSpinner(IDmodel);
        IDPanel.add(IDLabel);
        IDPanel.add(ID);
        patientpanel.add(IDPanel);
        ID.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                patient.setId(IDmodel.getNumber().intValue());
                info.setText("<html> Patient Data:       Blood Data: " + patient.bd.printBlood() +
                        "<br> Patient Age: " + patient.getAge() + "       Patient ID Number: " + patient.getId());
                revalidate();
                repaint();
            }
        });
        patientpanel.add(info);
        panel.add(patientpanel);
        return panel;
    }

    public TestPatient() {
        // set parameters of GUI
        setTitle("Scrhodingy's Patient Facility");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        new GridLayout(1, 1);

        JPanel superpanel = new JPanel(new GridLayout(1, 3));


        Patient patient2 = new Patient(0, 0, new BloodData());
        JPanel panel2 = new JPanel(new GridLayout(1, 1));
        JLabel info2 = new JLabel("", SwingConstants.CENTER);
        info2.setText(patient2.rep());
        panel2.add(info2);
        superpanel.add(panel2);

        Patient patient1 = new Patient();
        JPanel panel1 = createComponents(patient1, true);
        superpanel.add(panel1);

        Patient patient3 = new Patient();
        JPanel panel3 = createComponents(patient3, false);
        superpanel.add(panel3);


        add(superpanel);
        revalidate();
        repaint();
    }


    public static void main(String[] args) {
        TestPatient main = new TestPatient();
        main.setVisible(true);
    }
}