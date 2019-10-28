package Figures;

import Ogólnie.CommandLine;
import Positions.Point;

public class Node {

    private Point pointOnBoard;
    private Point pointOnBoardGame;
    private static final char[] body = {'[','x',']'};

    public Point getPointOnBoard() {
        return pointOnBoard;
    }

    public void setPointOnBoard(Point pointOnBoard) {
        this.pointOnBoard = pointOnBoard;
    }

    public void setPointOnBoard(int x, int y) {
        this.pointOnBoard = new Point(x,y);
    }

    public Point getPointOnBoardGame() {
        return pointOnBoardGame;
    }

    public void setPointOnBoardGame(Point pointOnBoardGame) {
        this.pointOnBoardGame = pointOnBoardGame;
    }

    public void setPointOnBoardGame(int x, int y) {
        this.pointOnBoardGame = new Point(x,y);
    }

    public char getBody(int index){
        return body[index];
    }

    public void goDown(){
        CommandLine.getInstance().deleteNodeFromBoard(this);
        pointOnBoard.setY(pointOnBoard.getY()+1);
        pointOnBoardGame.setY(pointOnBoardGame.getY()+1);
        CommandLine.getInstance().printNodeToBoard(this);
    }

    public int getYFromPointOfBoardGame(){
        return pointOnBoardGame.getY();
    }

    public void goUpInQuene(){
        CommandLine.getInstance().deleteNodeFromBoard(this);
        pointOnBoard.setY(pointOnBoard.getY()-4);
        CommandLine.getInstance().printNodeToBoard(this);
    }

    public void relocateBothPoints(int x, int y){
        this.relocateBoardPoint(x,y);
        this.relocateGameBoardPoint(x,y);
    }

    public void relocateGameBoardPoint(int x, int y){
        this.getPointOnBoardGame().relocate(x,y);
    }

    public void relocateBoardPoint(int x, int y){
        CommandLine.getInstance().deleteNodeFromBoard(this);
        this.getPointOnBoard().relocate(x*3,y);
        CommandLine.getInstance().printNodeToBoard(this);
    }

    @Override
    public String toString(){
        return String.valueOf(body);
    }

}
