import java.util.Scanner;

public class calculateFormula {
    public static void main(String[] args){
        double a = userInputNumber("Enter 1st parameter 'a': ");
        double b = userInputNumber("Enter 1st parameter 'b': ");
        double c = userInputNumber("Enter 1st parameter 'c': ");
        double d = userInputNumber("Enter 1st parameter 'd': ");
        boolean tf = zeroCheck(d); // check if d not zero
        if (tf == true){ // if not zero - calculate
            double calculations = formulaCalculation(a, b, c, d);

            System.out.println(calculations);
        }
        else{ // if zero - 'error' statement
            System.out.println("You can't divide by zero!");
        }
    }
    static double userInputNumber(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        double arg = userInput.nextDouble();
        return arg;
    }
    static boolean zeroCheck(double d){
        boolean result = false;
        if (d != 0){
            result = true;
        }
        return result;
    }

    static double formulaCalculation(double a, double b, double c, double d){
        return (a * (b + (c / d)));
    }
}