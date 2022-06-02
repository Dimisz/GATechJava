import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("List of operations: add,subtract, multiply, divide, and alphabetize.");
        System.out.print("Enter an operation: ");

        String operation = input.next();
        switch(operation){
            case "add":
                System.out.print("Enter two integers: ");
                int firstInt = input.nextInt();
                int secondInt = input.nextInt();
                System.out.println("Answer: " + (firstInt + secondInt));
                break;
            case "subtract":
                System.out.print("Enter two integers: ");
                firstInt = input.nextInt();
                secondInt = input.nextInt();
                System.out.println("Answer: " + (firstInt - secondInt));
                break;
            case "multiply":
                input.useLocale(Locale.US);
                System.out.print("Enter two doubles: ");
                double firstDouble = input.nextDouble();
                double secondDouble = input.nextDouble();
                System.out.printf("Answer: %.2f\n", (firstDouble * secondDouble));
                break;
            case "divide":
                input.useLocale(Locale.US);
                System.out.print("Enter two doubles: ");
                firstDouble = input.nextDouble();
                secondDouble = input.nextDouble();
                if(secondDouble != 0){
                    System.out.printf("Answer: %.2f\n", (firstDouble / secondDouble));
                }
                break;
            case "alphabetize":
                System.out.print("Enter two words: ");
                String firstString = input.next();
                String secondString = input.next();
                int comparison = firstString.compareTo(secondString);
                if(comparison < 0){
                    System.out.println(firstString + " comes before " +
                            secondString + " alphabetically.");
                }
                else if(comparison > 0){
                    System.out.println(firstString + " comes after " +
                            secondString + " alphabetically.");
                }
                else{
                    System.out.println(firstString + " and " +
                            secondString + " are alphabetically equal.");
                }
        }
    }
}
