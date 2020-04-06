import java.util.Scanner;

public class helloUsername {
    public static void main(String[] args){
        String username = userNameInput("Enter your name: ");

        System.out.println("Hello, " + username + "!");
    }
    static String userNameInput(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        String name = userInput.nextLine();
        return name;
    }
}