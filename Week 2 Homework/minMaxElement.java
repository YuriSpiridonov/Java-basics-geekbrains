public class minMaxElement {
    public static void main(String[] arfs) {
        int[] array = {101, 4, 32, 0, 1, -5, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = array[0];
        int max = array[0];
        for (int i = 1 ; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            }
            if (array[i] > max){
                max = array[i];
            }
        }
    System.out.println("Min number is "+ min);
    System.out.println("Max number is "+ max);
    }
}