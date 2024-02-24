import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> results = new ArrayList<>();

        while (true) {
            System.out.println("\nCalculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Find Minimum Number");
            System.out.println("7. Find Maximum Number");
            System.out.println("8. Find Average");
            System.out.println("9. Print Last Result");
            System.out.println("10. Print List of All Results");
            System.out.println("11. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = input.nextInt();

            if (choice == 11) {
                System.out.println("Exiting calculator.");
                break;
            }

            double num1, num2, num3;
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    System.out.print("Enter the first number: ");
                    num1 = input.nextDouble();
                    System.out.print("Enter the second number: ");
                    num2 = input.nextDouble();
                    System.out.print("Enter the third number: ");
                    num3 = input.nextDouble();
                    double result = calculateAndPrint(choice, num1, num2, num3);
                    results.add(result); // Add the result to the list
                    break;
                case 9:
                    lastResult(results);
                    break;
                case 10:
                    allResults(results);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 11.");
            }
        }
    }

    public static double calculateAndPrint(int choice, double num1, double num2, double num3) {
        double result = 0;
        switch (choice) {
            case 1:
                result = num1 + num2 + num3;
                break;
            case 2:
                result = num1 - num2 - num3;
                break;
            case 3:
                result = num1 * num2 * num3;
                break;
            case 4:
                if (num2 != 0 && num3 != 0) {
                    result = num1 / num2 / num3;
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;
            case 5:
                result = num1 % num2 % num3;
                break;
            case 6:
                result = Math.min(Math.min(num1, num2), num3);
                break;
            case 7:
                result = Math.max(Math.max(num1, num2), num3);
                break;
            case 8:
                result = (num1 + num2 + num3) / 3;
                break;
        }
        System.out.println("Result: " + result);
        return result;
    }

    public static void lastResult(ArrayList<Double> results) {
        if (!results.isEmpty()) {
            System.out.println("Last Result: " + results.get(results.size() - 1));
        } else {
            System.out.println("No calculations have been made yet.");
        }
    }

    public static void allResults(ArrayList<Double> results) {
        if (!results.isEmpty()) {
            System.out.println("List of All Results:");
            for (double res : results) {
                System.out.println(res);
            }
        } else {
            System.out.println("No calculations have been made yet.");
        }
    }
}
