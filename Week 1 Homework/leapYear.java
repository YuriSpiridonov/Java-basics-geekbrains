import java.util.Scanner;

public class leapYear {
    public static void main(String[] args){
        double year = userYearInput("Enter a year: ");
        String leap = leapYear(year);

        System.out.println(leap);
    }
    static double userYearInput(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        double year = userInput.nextInt();
        return year;
    }
    static String leapYear(double year){
        String result = "Year is not leap.";

        if ((year % 4 == 0 && !(year % 100 == 0)) || (year % 400 == 0)){
            result = "Year is leap.";
        }

        return result;
    }
}