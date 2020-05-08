package game;

public class MiniMax {
    private static int SIZE = 3;
    int row, col;

    private static final char EMPTY = '\u0000';
    private static final char X = 'X';
    private static final char O = 'O';

    static int evaluate(char map[][]){
        for (int row = 0; row < GameBoard.dimension; row++) {
            if (map[row][0] == map[row][1] && map[row][1] == map[row][2]) {
                if (map[row][0] == O) //ai
                    return +10;
                else if (map[row][0] == X) //human
                    return -10;
            }
        }
        for (int col = 0; col < GameBoard.dimension; col++) {
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
        if (!(isMapFull(map)))
            return 0;
        if (isMax){
            int best = -1000;
            for (int i = 0; i < GameBoard.dimension; i++){
                for (int j = 0; j < GameBoard.dimension; j++){
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
            for (int i = 0; i < GameBoard.dimension; i++){
                for (int j = 0; j < GameBoard.dimension; j++){
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

    static MiniMax findBestMove(char map[][]){
        int bestValue = -1000;
        MiniMax bestMove = new MiniMax();
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

    static Boolean isMapFull(char[][] map)
    {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == EMPTY)
                    return true;
        return false;
    }
}
