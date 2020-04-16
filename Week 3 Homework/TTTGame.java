import java.util.Scanner;

public class TTTGame {
    private static char[][] map;
    private static int SIZE = 3;
    int row, col;

    private static final char EMPTY = ' ';
    private static final char X = 'X';
    private static final char O = 'O';

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true){
            humanTurn();
            if(isEndGame(X)){
                break;
            }
            computerTurn();
            if(isEndGame(O)){
                break;
            }
        }
        System.out.println("Game Over");
    }
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0 ; j < SIZE; j++){
                map[i][j] = EMPTY;
            }
        }
    }
    private static void printMap() {
        for (int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++){
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void humanTurn() {
        int x , y;
        do{
            System.out.println("Enter coordinates: ");
            y = scanner.nextInt() -1;
            x = scanner.nextInt() -1;
        }while(!isCellValid(x, y));
        map[y][x] = X;

    }
    private static void computerTurn() {
        int x , y;
        TTTGame bestMove = findBestMove(map);
        y = bestMove.row;
        x = bestMove.col;
        System.out.println("Computer goes " + (y+1) + " " + (x+1));
        map[y][x] = O;
    }
    private static boolean isCellValid(int x, int y){
        boolean result = true;

        if (x < 0 || x > SIZE || y < 0 || y > SIZE) {
            result = false;
        }
        if (map[y][x] != EMPTY) {
            result = false;
        }

        return result;
    }
    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;
        printMap();
        if(checkWin(playerSymbol)) {
            System.out.println(playerSymbol + " is a Winner!");
            result = true;
        }
        if (!isMapFull(map) && !checkWin(playerSymbol)) {
            System.out.print("Draw.");
            result = true;
        }
        return result;
    }
    static Boolean isMapFull(char[][] map)
    {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == EMPTY)
                    return true;
        return false;
    }
    public static boolean checkWin(char playerSymbol) {
        boolean result = false;
        if(
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)
        ){
            result = true;
        }
        return result;
    }
    static int evaluate(char map[][]){
        for (int row = 0; row < SIZE; row++) {
            if (map[row][0] == map[row][1] && map[row][1] == map[row][2]) {
                if (map[row][0] == O) //ai
                    return +10;
                else if (map[row][0] == X) //human
                    return -10;
            }
        }
        for (int col = 0; col < SIZE; col++) {
            if (map[0][col] == map[1][col] && map[1][col] == map[2][col]) {
                if (map[0][col] == O) //ai
                    return +10;
                else if (map[0][col] == X) //human
                    return -10;
            }
        }
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2])
        {
            if (map[0][0] == O)
                return +10;
            else if (map[0][0] == X)
                return -10;
        }
        if (map[0][2] == map[1][1] && map[1][1] == map[2][0])
        {
            if (map[0][2] == O)
                return +10;
            else if (map[0][2] == X)
                return -10;
        }
        return 0;
    }
    static int minimax(char map[][], int depth, Boolean isMax){
        int score = evaluate(map);
        if (score == 10)
            return score;
        if (score == -10)
            return score;
        if (isMapFull(map) == false)
            return 0;
        if (isMax){
            int best = -1000;
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    if (map[i][j] == EMPTY){
                        map[i][j] = O;
                        best = Math.max(best, minimax(map, depth+1, !isMax));
                        map[i][j] = EMPTY;
                    }
                }
            }
            return best;
        }
        else {
            int best = 1000;
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    if (map[i][j] == EMPTY){
                        map[i][j] = X;
                        best = Math.min(best, minimax(map, depth+1, !isMax));
                        map[i][j] = EMPTY;
                    }
                }
            }
            return best;
        }
    }
    static TTTGame findBestMove(char map[][]){
        int bestValue = -1000;
        TTTGame bestMove = new TTTGame();
        bestMove.row = 0;
        bestMove.col = 0;
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == EMPTY){
                    map[i][j] = O;
                    int moveValue = minimax(map, 0, false);
                    map[i][j] = EMPTY;
                    if (moveValue > bestValue){
                        bestMove.row = i;
                        bestMove.col = j;
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }
}
