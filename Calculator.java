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

            System.out.print("Enter the first number: ");
            double num1 = input.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = input.nextDouble();
            System.out.print("Enter the third number: ");
            double num3 = input.nextDouble();

            double result = 0;

            switch (choice) {
                case 1:
                    result = num1 + num2 + num3;
                    System.out.print(result);
                    break;
                case 2:
                    result = num1 - num2 - num3;
                    System.out.print(result);
                    break;
                case 3:
                    result = num1 * num2 * num3;
                    System.out.print(result);
                    break;
                case 4:
                    if (num2 != 0 && num3 != 0) {
                        result = num1 / num2 / num3;
                        System.out.print(result);
                    } else {
                        System.out.println("Cannot divide by zero!");
                    }
                    break;
                case 5:
                    result = num1 % num2 % num3;
                    System.out.print(result);
                    break;
                case 6:
                    result = Math.min(Math.min(num1, num2), num3);
                    System.out.print(result);
                    break;
                case 7:
                    result = Math.max(Math.max(num1, num2), num3);
                    System.out.print(result);
                    break;
                case 8:
                    result = (num1 + num2 + num3) / 3;
                    System.out.print(result);
                    break;
                case 9:
                    if (!results.isEmpty()) {
                        System.out.println("Last Result: " + results.get(results.size() - 1));
                    } else {
                        System.out.println("No operations have been performed yet.");
                    }
                    break;
                case 10:
                    if (!results.isEmpty()) {
                        System.out.println("List of All Results:");
                        for (double res : results) {
                            System.out.println(res);
                        }
                    } else {
                        System.out.println("No operations have been performed yet.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 11.");
            }

            if (choice >= 1 && choice <= 8) {
                results.add(result);
            }
        }
    }
}
