import javax.swing.*;

public class Party {
    int guests;
    Party(){}
    public int getGuests() {
        return guests;
    }
    public void setGuests(int guests) {
        this.guests = guests;
    }
    public JLabel displayInvitation() {
        return new JLabel("Please come to my party!", SwingConstants.CENTER);
    }
}

