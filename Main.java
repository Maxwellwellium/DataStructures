import java.util.*;

public class Main {
    public static void main(String[] args) {
        // prompt user to enter info
        System.out.println("Please enter amount of money and currency. Ex: '4.25 Dollars'");

        // define string arrays of accepted currencies
        String[] USD = new String[] {" usd", "united states dollar", "united states dollars", "dollars", "dollar"};
        String[] EUR = new String[] {" eur", "euro", "euros"};
        String[] GBP = new String[] {" gbp", "great british pound", "great british pounds", "pounds", "pound"};
        String[] CAD = new String[] {" cad", "canadian dollar", "canadian dollars", };
        String[][] currencylist = {USD, EUR, GBP, CAD};

        // initialize variables
        double amount = 0.00f;
        String currency = null;
        boolean iscurrency = true;
        String currencytype = null;

        do {
            //redefines variables as user input, continues to prompt user until they enter info correctly
            try {
                // create new scanner
                Scanner sc = new Scanner(System.in);
                amount = sc.nextDouble();
                currency = sc.nextLine();
                currency = currency.toLowerCase();
            }
            catch (Exception e) {
                System.out.println("Couldn't determine the amount and currency, please enter in the correct format");
                amount = 0.00f;
                currency = null;
            }
        }
        while (amount == 0.00f && currency == null);

        // checks if currency is valid
        for (String[] s : currencylist) {
            String type = Arrays.toString(s);

            iscurrency = type.contains(currency);
            if (iscurrency) {
                currencytype = (String) (s[0]);
                break;
            }
        }
        if (!iscurrency) {
            System.out.println("Accepted currencies are: USD, EUR, GBP, CAD.");
            System.exit(0);
        }

        System.out.println("Calculating: " + amount + " in" + currencytype);

        // convert any given amount to USD
        double conversion = 1;
        if (Objects.equals(currencytype, " eur")) {
            conversion = 1.09;
        }
        else if (Objects.equals(currencytype, " gbp")) {
            conversion = 1.27;
        }
        else if (Objects.equals(currencytype, " cad")) {
            conversion = 0.74;
        }

        // multiply by 100 in order to easily use floor division later on
        double usdamount = ((amount * conversion) * 100);
        int remainder = (int) usdamount;

        // tell user what amount is in USD if it hasn't been given
        if (!Objects.equals(currencytype, " usd")) {
            System.out.println("Which is roughly " + usdamount / 100 + " in USD");
        }

        // using module and floor division, find out how many of each coin you'd have
        int quarters = java.lang.Math.floorDiv(remainder, 25);
        remainder = remainder % 25;
        int dimes = java.lang.Math.floorDiv(remainder, 10);
        remainder = remainder % 10;
        int nickels = java.lang.Math.floorDiv(remainder, 5);
        remainder = remainder % 5;
        int pennies = remainder;

        // print this information into the terminal
        System.out.println("You'd have:");
        System.out.println(quarters + " Quarters");
        System.out.println(dimes + " Dimes");
        System.out.println(nickels + " Nickels");
        System.out.println("and " + pennies + " Pennies");
    }
}