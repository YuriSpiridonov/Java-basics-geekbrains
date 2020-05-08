package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int col;
    private GameButton button;

    public GameActionListener(int row, int col, GameButton gButton){
        this.row = row;
        this.col = col;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if(board.isTurneble(row, col)){
            updateByPlayersData(board);

            if (board.isFull()){
                board.getGame().showMessage("It's a draw!");
                board.emptyField();
                Game.playersTurn = 0; //
            }
            else{
                updateByAiData(board);
            }
        }
        else{
            board.getGame().showMessage("Turn not allowed!");
        }
    }

    private void updateByPlayersData(GameBoard board){
        board.updateGameField(row, col);

        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin()){
            button.getBoard().getGame().showMessage("You Win!");
            board.emptyField();
            Game.playersTurn = 0; //
        }
        else{
            board.getGame().passTurn();
        }
    }

    private void updateByAiData(GameBoard board){
        int x, y;

        MiniMax bestMove = MiniMax.findBestMove(GameBoard.gameField);
        do {
            y = bestMove.row;
            x = bestMove.col;
        }while(!board.isTurneble(x, y));

        board.updateGameField(x, y);

        int cellIndex = GameBoard.dimension*x+y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin()){
            button.getBoard().getGame().showMessage("AI Win!");
            board.emptyField();
            Game.playersTurn = 0; //
        }
        else{
            board.getGame().passTurn();
        }
    }
}
