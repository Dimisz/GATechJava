import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");

        String operation = input.next().toLowerCase();
        switch(operation){
            case "add":
                System.out.println("Enter two integers:");
                int firstInt = 0;
                int secondInt = 0;
                if(input.hasNextInt()){
                    firstInt = input.nextInt();
                }
                else{
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                if(input.hasNextInt()){
                    secondInt = input.nextInt();
                    System.out.println("Answer: " + (firstInt + secondInt));
                    break;
                }
                else{
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "subtract":
                System.out.println("Enter two integers:");
                int firstNum = 0;
                int secondNum = 0;
                if(input.hasNextInt()){
                    firstNum = input.nextInt();
                }
                else{
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                if(input.hasNextInt()){
                    secondNum = input.nextInt();
                    System.out.println("Answer: " + (firstNum - secondNum));
                    break;
                }
                else{
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "multiply":
                input.useLocale(Locale.US);
                System.out.println("Enter two doubles:");
                double firstDouble = 0.0;
                double secondDouble = 0.0;
                if(input.hasNextDouble()) {
                    firstDouble = input.nextDouble();
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                if(input.hasNextDouble()) {
                    secondDouble = input.nextDouble();
                    System.out.printf("Answer: %.2f\n", (firstDouble * secondDouble));
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                break;
            case "divide":
                input.useLocale(Locale.US);
                System.out.println("Enter two doubles:");
                double first = 0.0;
                double second = 0.0;
                if(input.hasNextDouble()) {
                    first = input.nextDouble();
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                if(input.hasNextDouble()) {
                    second = input.nextDouble();
                    if(second != 0) {
                        System.out.printf("Answer: %.2f\n", (first / second));
                    }
                    else{
                        System.out.println("Invalid input entered. Terminating...");
                    }
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                break;
            case "alphabetize":
                System.out.println("Enter two words:");
                String firstString = input.next();
                String secondString = input.next();
                int comparison = firstString.toLowerCase().compareTo(secondString.toLowerCase());
                if(comparison < 0){
                    System.out.println("Answer: " + firstString + " comes before " +
                            secondString + " alphabetically.");
                }
               else if(comparison > 0){
                    System.out.println("Answer: " + secondString + " comes before " +
                            firstString + " alphabetically.");
                }
                else{
                    System.out.println("Answer: Chicken or Egg.");
                }
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
        }
    }
}
