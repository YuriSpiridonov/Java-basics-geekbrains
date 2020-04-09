public class squareArray {
    public static void main(String[] args) {
        int[][] tableArray = new int[10][10];
        for (int i = 0; i < tableArray.length; i++) {
            for(int j = 0; j < tableArray.length; j++) {
                if (i == j) {
                    tableArray[i][j] = 1;
                }
            }
        }
        printTableArray(tableArray);
    }
    public static void printTableArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}