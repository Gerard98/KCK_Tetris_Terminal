package Ogólnie;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CommandLine {

    private final String LEVEL = "Level:";
    private final String SCORE = "Score:";
    public static final int BOARD_HEIGHT = 22;
    public static final int BOARD_WIDTH = 64;

    /**
     * Dodałem to aby mieć 2 współrzędne, 1 do jakby wypisywania znaków w konsoli
     * a druga właśnie ta intowa aby sprawdzać czy jest jakiś klocek niżej czy z boku
     * myślę że tak będzie lepiej bo nie będziemy musieli się jebać z tymi potrójnymi współrzędnymi
     *
     * Zmieniłem też nazwę tego pola GAME_BOARD_HEIGHT na GAME_BOARD aby sie nie jebaly pozniej te plansze
     *
     * No i dodałem plasę Point która po prostu trzyma x i y
     *
     * Node to po prostu klasa 1 kwadratu czyli [x] która trzyma współrzędne tego kwadratu na obu planszach
     *
     * Myślę że metody takie jak goDown czy checkDownFloor by mogły być w Figure ale trzeba ogarnąć aby ta lista była w Figure a nie w Square
     *
     * Pozdrawiam
     * Gercio Pierdzio
     */


    private static int[][] gameBoard = {
            { 1,1,1,1,1,1,1,1,1,1,1,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,0,0,0,0,0,0,0,0,0,0,1},
            { 1,1,1,1,1,1,1,1,1,1,1,1},
    };

    private int level;
    private int score;




    private char[][] board;
    private TextGraphics textGraphics;
    private Terminal terminal;
    private Screen screen;
    private static CommandLine commandLine = new CommandLine();

    private CommandLine() {
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            textGraphics = screen.newTextGraphics();

            //terminal.addResizeListener(new MyResizeListener(terminal.getTerminalSize()));

            board = new char[BOARD_HEIGHT][BOARD_WIDTH];
            screen.startScreen();
            loadGameBoardFromFile();
            printScoreBoard();
            printGameWindow();
            refresh();



        }catch (IOException ex){
            System.out.print("There is problem with Terminal");
            ex.printStackTrace();
        }
    }


    public Screen getScreen() {
        return screen;
    }

    public static CommandLine getInstance(){
        return commandLine;
    }

    public void putChar(int x, int y, char a){
        try {
            textGraphics.putString(x, y, String.valueOf(a));
            screen.refresh();
        }catch (IOException ex){
            System.out.print("Problem with adding char into terminal");
            ex.printStackTrace();
        }
    }

    public void putString(int x, int y, String s){
        try {
            textGraphics.putString(x, y, s);
            screen.refresh();
        }catch (IOException ex){
            System.out.print("Problem with adding char into terminal");
            ex.printStackTrace();
        }
    }

    public void refresh(){
        try {
            //screen.clear();
            screen.refresh();
        }catch (IOException ex){ex.printStackTrace();}
    }

    public void printGameWindow(){

        for(int i = 0; i< BOARD_HEIGHT; i++){
            for(int j = 0; j< BOARD_WIDTH; j++){
                putChar(j,i+2, board[i][j]);

            }
        }
    }

    public void printScoreBoard(){
        String scoreBoard = "[ " + LEVEL + " " + level + " | " + SCORE + " " + score + " ]";
        putString(0,0,scoreBoard);
    }


    public void loadGameBoardFromFile(){
        try {

            Scanner sc = new Scanner(new File("gameBoard.txt"));
            String lane;
            for(int i = 0; i< BOARD_HEIGHT; i++){
                lane = sc.nextLine();
                System.out.println(lane);
                for(int j = 0; j< BOARD_WIDTH; j++){
                    board[i][j] = lane.charAt(j);
                    //putChar(j,i+2,gameBoard[i][j]);
                }
            }

        }catch (FileNotFoundException ex){
            System.out.println("The file gameBoard.txt doesnt exist");
            ex.printStackTrace();
        }

    }

    static class MyResizeListener extends SimpleTerminalResizeListener {

        public MyResizeListener(TerminalSize initialSize){
            super(initialSize);
        }

        @Override
        public synchronized void onResized(Terminal terminal, TerminalSize newSize) {
            super.onResized(terminal, newSize);
            CommandLine.getInstance().refresh();
        }
    }

}
