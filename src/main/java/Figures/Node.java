package Figures;

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
}
