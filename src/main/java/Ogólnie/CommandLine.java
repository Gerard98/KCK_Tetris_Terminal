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
    private final int GAME_BOARD_HEIGHT = 22;
    private final int GAME_BOARD_WIDTH = 64;


    private int level;
    private int score;

    private char[][] gameBoard;
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

            gameBoard = new char[GAME_BOARD_HEIGHT][GAME_BOARD_WIDTH];
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

        for(int i=0;i<GAME_BOARD_HEIGHT;i++){
            for(int j=0;j<GAME_BOARD_WIDTH;j++){
                putChar(j,i+2,gameBoard[i][j]);

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
            for(int i=0;i<GAME_BOARD_HEIGHT;i++){
                lane = sc.nextLine();
                System.out.println(lane);
                for(int j=0;j<GAME_BOARD_WIDTH;j++){
                    gameBoard[i][j] = lane.charAt(j);
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
