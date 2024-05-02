import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {
    public Main() throws IOException {
        System.out.println("Is your object of great importance to you?");
        Scanner x = new Scanner(System.in);
        if (x.next() != null) {
            System.out.println("I'd like to redeem my hackathon credit for this assignment.");
        }

    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.setVisible(true);
    }
}