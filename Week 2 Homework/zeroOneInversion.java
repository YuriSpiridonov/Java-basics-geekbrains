import java.util.Arrays;

public class zeroOneInversion {
    public static void main(String[] args) {
        int[] array = {1,0,1,0,1,0,0,0,1,1,1,1,0,1,0};
        System.out.println("Array:     "+Arrays.toString(array));

        for (int i = 0; i < array.length ; i++) {
            if (array[i] == 0) {
                array[i] = 1;
                //array[0]++;
                //array[i] += 1;
                //array[i] = array[i] + 1
            }
            else {
                array[i] = 0;
            }
        }
        System.out.println("New array: "+Arrays.toString(array));
    }
}
