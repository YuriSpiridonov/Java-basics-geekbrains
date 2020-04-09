import java.util.Arrays;

public class arra8 {
    public static void main(String[] args) {
        int[] array = new int[8];
        int number = 0;

        for (int index = 0 ; index < array.length ; index++) {
            array[index] = number;
            number+=3;
        }
        System.out.println(Arrays.toString(array));
    }
}