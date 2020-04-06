import java.util.Scanner;

public class negativeIsTrue {
    public static void main(String[] args){
        int number = inputArgument("Enter a number: ");
        boolean statement = positiveOrNegative(number);

        System.out.println(statement);
    }
    static int inputArgument(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        int arg = userInput.nextInt();
        return arg;
    }
    static boolean positiveOrNegative(int number){
        boolean result = false; // more then -1

        if(number < 0){
            result = true; // less then 0
        }
        return result;
    }
}
// -0 is false. Why? ;)