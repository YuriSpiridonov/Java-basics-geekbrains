package game;

import javax.swing.*;

public class Game {
    // link to game board
    private GameBoard board;
    //array og players
    private GamePlayer[] gamePlayers = new GamePlayer[2];
    //current player index
    public static int playersTurn = 0; //human go first // private not static

    public Game(){
        this.board = new GameBoard(this);
    }

    public void initGame(){
        gamePlayers[0] = new GamePlayer(true, 'X');
        gamePlayers[1] = new GamePlayer(false, 'O');
    }

    void passTurn(){
        if(playersTurn == 0){
            playersTurn = 1;
        }
        else{
            playersTurn = 0;
        }
    }
    GamePlayer getCurrentPlayer(){
        return gamePlayers[playersTurn];
    }
    void showMessage(String messageTest){
        JOptionPane.showMessageDialog(board, messageTest);
    }
}
