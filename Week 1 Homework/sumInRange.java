import java.util.Scanner;

public class sumInRange {
    public static void main(String[] args) {
        double arg1 = inputArgument("Enter 1st number: ");
        double arg2 = inputArgument("Enter 2nd number: ");
        double sum = (arg1 + arg2); // we can delete this line
        boolean bool = validateRange(sum); // replace 'sum' with 'arg1 + arg2'
                                           // and get same result
        System.out.println(bool);
    }

    static double inputArgument(String userText) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        double arg = userInput.nextDouble();
        return arg;
    }
    static boolean validateRange(double sum) {
        boolean result = true; // if in range 10:20 including 10 and 20

        if (sum < 10 || sum > 20) {
            result = false; // if 9 and less or 21 and more
        }
        return result;
    }
}