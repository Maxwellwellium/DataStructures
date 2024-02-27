import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionLab {
    public static double exceptionLab() {
        Scanner numberInput = new Scanner(System.in);
        int num1;
        int num2;
        double output = 0;
        try {
            num1 = numberInput.nextInt();
            num2 = numberInput.nextInt();
            output = num1 / num2;
            System.out.println("answer: " + output);
        } catch(ArithmeticException arithmeticException) {
            System.out.println("The Program has run into an arithmetic error, do not make the divisor 0.");
        } catch(InputMismatchException inputMismatchException) {
            System.out.println("The Program has run into an input error, please enter a correctly formatted number.");
        } catch(Exception e) {
            System.out.println("The Program has run into an unknown error.");
        }
        return output;
    }
    public static void main(String[] args) {
        double number = exceptionLab();
    }
}