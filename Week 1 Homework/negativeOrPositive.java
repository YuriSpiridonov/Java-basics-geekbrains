import java.util.Scanner;

public class negativeOrPositive {
    public static void main(String[] args){
        int number = inputArgument("Enter a number: ");
        // also we can make it in a method -v
        if(number < 0){
            System.out.println("negative"); // less then 0
        }
        else{
            System.out.println("positive");
        }

    }
    static int inputArgument(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        int arg = userInput.nextInt();
        return arg;
    }
}