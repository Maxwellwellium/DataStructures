import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseDinnerParty extends JFrame {
    public UseDinnerParty() {
        Party currentParty = new Party();
        DinnerParty currentDinnerParty = new DinnerParty();

        // set parameters of GUI
        setTitle("Party Planner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        // party parameters
        JTextField guestInput = new JTextField();
        JLabel guestInputText = new JLabel("Enter number of guests attending the Party.", SwingConstants.CENTER);

        JPanel partyPanel = new JPanel(new GridLayout(4, 1));
        partyPanel.add(guestInputText);
        partyPanel.add(guestInput);


        // dinner party parameters
        JTextField dinnerGuestInput = new JTextField();
        JLabel dinnerGuestInputText = new JLabel("Enter number of guests attending the Dinner Party.", SwingConstants.CENTER);
        JTextField choiceInput = new JTextField();
        JLabel choiceInputText = new JLabel("Enter the menu option -- 1 for chicken or 2 for Vegi", SwingConstants.CENTER);


        JPanel dinnerPartyPanel = new JPanel(new GridLayout(7, 1));
        dinnerPartyPanel.add(dinnerGuestInputText);
        dinnerPartyPanel.add(dinnerGuestInput);
        dinnerPartyPanel.add(choiceInputText);
        dinnerPartyPanel.add(choiceInput);


        // action listeners
        guestInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guests = Integer.parseInt(guestInput.getText());
                currentParty.setGuests(guests);
                int guestsAttending = currentParty.getGuests();
                JLabel guestOutputText = new JLabel("The party has " + guestsAttending + " guests!", SwingConstants.CENTER);
                JLabel displayInv = currentParty.displayInvitation();

                JLabel venue = new JLabel("", SwingConstants.CENTER);
                switch((1 <= guestsAttending && guestsAttending <= 30 ) ? 0 :
                        (30 <= guestsAttending && guestsAttending <= 90) ? 1 :
                                (90 <= guestsAttending && guestsAttending <= 200) ? 2 :
                                        (200 <= guestsAttending && guestsAttending <= 1000) ? 3: 4) {
                    case 0:
                        venue.setText("The party will take place at my house!");
                        break;
                    case 1:
                        venue.setText("The party will take place at a small venue!");
                        break;
                    case 2:
                        venue.setText("The party will take place at a medium venue!");
                        break;
                    case 3:
                        venue.setText("The party will take place at a large venue!");
                        break;
                    default:
                        venue.setText("The party's location is still being determined.");
                }

                partyPanel.removeAll();
                partyPanel.add(guestOutputText);
                partyPanel.add(venue);
                partyPanel.add(displayInv);
                partyPanel.revalidate();
                partyPanel.repaint();
            }});
        dinnerGuestInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dinnerGuests = Integer.parseInt(dinnerGuestInput.getText());
                currentDinnerParty.setGuests(dinnerGuests);
                int dinnerGuestsAttending = currentDinnerParty.getGuests();
                JLabel dinnerGuestOutputText = new JLabel("The dinner party has " + dinnerGuestsAttending + " guests!", SwingConstants.CENTER);

                JLabel venue = new JLabel("", SwingConstants.CENTER);
                switch((1 <= dinnerGuestsAttending && dinnerGuestsAttending <= 20 ) ? 0 :
                        (20 <= dinnerGuestsAttending && dinnerGuestsAttending <= 50) ? 1 :
                                (50 <= dinnerGuestsAttending && dinnerGuestsAttending <= 150) ? 2 :
                                        (150 <= dinnerGuestsAttending && dinnerGuestsAttending <= 1000) ? 3: 4) {
                    case 0:
                        venue.setText("The dinner party's food will be cooked by me!");
                        break;
                    case 1:
                        venue.setText("The dinner party's food will be cooked by several guests alongside myself!");
                        break;
                    case 2:
                        venue.setText("The dinner party's food will be catered by a local restaurant!");
                        break;
                    case 3:
                        venue.setText("The dinner party's food will be catered by BigY!");
                        break;
                    default:
                        venue.setText("The dinner party's cooking is still being decided.");
                }


                dinnerPartyPanel.remove(dinnerGuestInputText);
                dinnerPartyPanel.remove(dinnerGuestInput);
                dinnerPartyPanel.add(dinnerGuestOutputText);
                dinnerPartyPanel.add(venue);
                dinnerPartyPanel.revalidate();
                dinnerPartyPanel.repaint();

            }});
        choiceInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dinnerChoice = Integer.parseInt(choiceInput.getText());
                currentDinnerParty.setChoices(dinnerChoice);
                int dinnerChosen = currentDinnerParty.getChoices();
                JLabel dinnerChosenText = new JLabel("Menu Option " + dinnerChosen + " will be served!", SwingConstants.CENTER);
                JLabel dinnerDisplayInv = currentParty.displayInvitation();
                dinnerPartyPanel.remove(choiceInputText);
                dinnerPartyPanel.remove(choiceInput);
                dinnerPartyPanel.add(dinnerChosenText);
                dinnerPartyPanel.add(dinnerDisplayInv);
                dinnerPartyPanel.revalidate();
                dinnerPartyPanel.repaint();
            }});

        setLayout(new GridLayout(2, 1));
        add(partyPanel);
        add(dinnerPartyPanel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new UseDinnerParty();
    }
}
