import java.util.Locale;
import java.util.Scanner;

public class FahrenheitToCelcius {
    public static void main(String[] args) {
        final int MIN_TEMP = 70;
        final int MAX_TEMP = 90;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Fahrenheit value: ");
        int fahrenheitValue = input.nextInt();
        System.out.println("Enter a day of the week: ");
        String day = input.next();
        double celcius = (5.0/9) * (fahrenheitValue - 32);

        boolean raining = false;
        System.out.println("Is it raining? (y/n): ");
        String rainInput = input.next().toLowerCase();
        if(rainInput.startsWith("y")){
            raining = true;
        }

        System.out.println(day + " Fahrenheit: " + fahrenheitValue);
        System.out.printf("%s Celcius: %.1f \n", day, celcius);

        if(fahrenheitValue >= MIN_TEMP && fahrenheitValue <= MAX_TEMP && !raining){
            System.out.println("Yay! Go to park.");
        }
        else{
            System.out.println("Stay home");
        }
    }
}
