import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // create Scanner class object to read input
        Scanner scan = new Scanner(System.in);

        // variables
        double principle = 0.0;
        double rate = 0.0;
        double time = 0.0;
        double payment = 0.0;

        // take input values
        System.out.print("Enter Principal Amount: ");
        principle = scan.nextDouble();
        System.out.print("Enter Interest Rate: ");
        rate = scan.nextDouble();
        System.out.print("Enter Time (in years): ");
        time = scan.nextDouble();

        // calculate monthly payment
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        payment = calculator(principle, rate, time);
        String formatter = currencyFormat.format(payment);
        // results
        System.out.println("Monthly Payment = "+formatter+ payment);

        // close scan
        scan.close();

    }

    public static double calculator(double principle, double rate,
                                    double time) {
        // convert monthly rate
        rate = (rate / 100) / 12;

        // convert time in the terms of months
        time = time * 12;
        // M = P [{r*(1+r)^n}/{(1+r)^n – 1}]
        double payment = principle * ((rate * Math.pow(1 + rate, time))
                / (Math.pow(1 + rate, time) - 1));
        return payment;
    }
}

