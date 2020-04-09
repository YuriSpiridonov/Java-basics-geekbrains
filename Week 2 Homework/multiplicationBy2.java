import java.util.Arrays;

public class multiplicationBy2 {
    public static void main(String[] args) {
        int[] array =  {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Array before: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i]*=2;
            }
        }
        System.out.println("Array after:  " + Arrays.toString(array));
    }
}