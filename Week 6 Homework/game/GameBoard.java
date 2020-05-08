package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    //size
    static int dimension = 3;
    //size of the button
    static int cellSize = 150;
    //game matrix
    public static char[][] gameField;
    //array of buttons
    private GameButton[] gameButtons;

    //game link
    private Game game;

    //null symbol
    static char nullSymbol = '\u0000'; //unicode value

    public GameBoard(Game currentGame){
        this.game = currentGame;
        initField();
    }

    private void initField(){
        // game settings
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300);
        setTitle("Tic Tac Toe MiniMax HARDCORE!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();

                //if (!(GamePlayer.isRealPlayer())){
                //    GamePlayer.realPlayer = true;
               //     return GamePlayer.realPlayer ;
              // }
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * dimension, 150);

        JPanel gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(dimension,dimension));

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        //generate game field
        for (int i = 0; i < (dimension * dimension); i++){
            GameButton fieldButton = new GameButton(i,this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    void emptyField(){
        for (int i = 0; i < (dimension * dimension); i++){
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol;
        }
    }

    Game getGame(){
        return game;
    }

    boolean isTurneble(int x, int y){
        boolean result = false;

        if (gameField[y][x] == nullSymbol){
            result = true;
        }

        return result;
    }

    void updateGameField(int x, int y){
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

    boolean checkWin(){
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)){
            result = true;
        }

        return result;
    }

    private boolean checkWinLines(char playerSymbol){
        boolean cols, rows, result;

        result = false;

        for (int col = 0; col < dimension; col++){
            cols = true;
            rows = true;

            for (int row = 0; row < dimension; row++){
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }

            if ( cols || rows){
                result = true;
                break;
            }

            if(result){
                break;
            }
        }

        return result;
    }

    private boolean checkWinDiagonals(char playerSymbol){
        boolean leftRight, rightLeft, result;

        leftRight = true;
        rightLeft = true;
        result = false;

        for (int i = 0; i < dimension; i++){
            leftRight &= (gameField[i][i] == playerSymbol);
            rightLeft &= (gameField[dimension -i -1][i] == playerSymbol);
        }

        if (leftRight || rightLeft){
            result = true;
        }

        return result;
    }
 /*
    boolean checkWin(){
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)){
            result = true;
        }
        return result;
    }
*/
    boolean isFull(){
        boolean result = true;

        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                if (gameField[i][j] == nullSymbol){
                    result = false;
                }
            }
        }
        return result;
    }

    public GameButton getButton(int buttonIndex){
        return gameButtons[buttonIndex];
    }
 }
