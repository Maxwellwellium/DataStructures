import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static double[] ArrayLab() {
        double[] doubleArray = new double[20];
        for (double d : doubleArray) {
            d = 0.00F;
        }
        System.out.println("Please enter a decimal.");
        Scanner decimalsEntered = new Scanner(System.in);
        for (int index = 0; index <  20; index++) {
            double newDecimal;
            try {
                newDecimal = decimalsEntered.nextDouble();
                if (newDecimal == 99999) {
                    break;
                }
                doubleArray[index] = newDecimal;
            }
            catch (Exception e){
                System.out.println("Invalid input!");
                decimalsEntered.nextLine();
                index -= 1;
            }
        }
        return doubleArray;
    }
    public static void main(String[] args) {
        double[] arrayMain = ArrayLab();
        if (arrayMain[0] == 0.00) {
            System.out.println("Error, no inputs given!");
        }else {
            System.out.println(Arrays.toString(arrayMain));
        }
    }
}