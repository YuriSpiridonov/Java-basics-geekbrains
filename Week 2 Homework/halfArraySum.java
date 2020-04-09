public class halfArraySum {
    public static void main(String[] args) {
        int[] array = {1,1,1,3}; // array, you can change it as you wish
        boolean bool = sumInArray(array);

        System.out.print(bool);
    }

    static boolean sumInArray(int[] array) {
        // sum all array elements
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        // check equal sums
        boolean result = false;
        /*
        if sum of all elements in array dividing by 2 without remainder
        this array will have equal sums in left and right parts
         */
        if (sum % 2 == 0) {
            result = true;
        }
        return result;
    }
}