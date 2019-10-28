package Figures;

import Ogólnie.CommandLine;
import Positions.Point;

import java.util.LinkedList;
import java.util.List;

public abstract class Figure {

    private List<Node> figure;

    public abstract void setPositionInQuene();
    public abstract void setPositionToFall();
    public abstract void rotate();


    public Figure(){

        figure = new LinkedList<>();
        setPositionInQuene();

    }

    public void printNodeToBoard(Node node){
        CommandLine.getInstance().printNodeToBoard(node);
    }

    public void deleteNodeFromBoard(Node node){
        CommandLine.getInstance().deleteNodeFromBoard(node);
    }

    public List<Node> getFigure() {
        return figure;
    }

    public void setFigure(List<Node> figure) {
        this.figure = figure;
    }

    public void addNode(Node node){
        figure.add(node);
    }

    public void setNewGameBoardPoints(){
        getFigure().forEach(m -> {
            Point point = m.getPointOnBoardGame();
            CommandLine.getInstance().changeValueOfGameBoard(point.getX(), point.getY(), 1);

        });

    }

    public boolean checkForEndGame(){
        return getFigure().stream().anyMatch(m -> m.getPointOnBoardGame().getY() <= 1);
    }

    public boolean checkDownFloorIsFree(){
        boolean check = figure.stream().anyMatch(m -> {
            int[][] gameBoard = CommandLine.getInstance().getGameBoard();
            Point point = m.getPointOnBoardGame();

            return gameBoard[point.getY()+1][point.getX()] == 1;

        });

        return !check;

    }

    public void goDown(){
        figure.forEach(m -> {
            Point pointOnBoard = m.getPointOnBoard();
            Point pointOnGameBoard = m.getPointOnBoardGame();
            deleteNodeFromBoard(m);
            pointOnGameBoard.setY(pointOnGameBoard.getY()+1);
            pointOnBoard.setY(pointOnBoard.getY()+1);
            printNodeToBoard(m);

        });

    }

    public boolean checkRightSideIsFree(){

        boolean check = figure.stream().anyMatch(m -> {
            int[][] gameBoard = CommandLine.getInstance().getGameBoard();
            Point point = m.getPointOnBoardGame();

            return gameBoard[point.getY()][point.getX()+1] == 1;

        });

        return !check;

    }

    public void goRight(){
        if(checkRightSideIsFree()) {
            figure.forEach(m -> {
                deleteNodeFromBoard(m);
            });

            figure.forEach(m -> {
                Point pointOnBoard = m.getPointOnBoard();
                Point pointOnGameBoard = m.getPointOnBoardGame();

                pointOnGameBoard.setX(pointOnGameBoard.getX() + 1);
                pointOnBoard.setX(pointOnBoard.getX() + 3);
                printNodeToBoard(m);
            });
        }
    }

    public boolean checkLeftSideIsFree(){
        boolean check = figure.stream().anyMatch(m -> {
            int[][] gameBoard = CommandLine.getInstance().getGameBoard();
            Point point = m.getPointOnBoardGame();

            return gameBoard[point.getY()][point.getX()-1] == 1;

        });

        return !check;
    }


    public void goLeft(){
        if(checkLeftSideIsFree()) {
            figure.forEach(m -> {
                deleteNodeFromBoard(m);
            });

            figure.forEach(m -> {
                Point pointOnBoard = m.getPointOnBoard();
                Point pointOnGameBoard = m.getPointOnBoardGame();
                pointOnGameBoard.setX(pointOnGameBoard.getX() - 1);
                pointOnBoard.setX(pointOnBoard.getX() - 3);
                printNodeToBoard(m);
            });
        }
    }

    public void goUpInQuene(){
        figure.forEach(m -> {
            m.goUpInQuene();
        });
    }

    public void goDownByTabInt(int[] tab){
        for(int i: tab){
            figure.get(i).goDown();
        }
    }

    public boolean isAvailableToRotate(int x1, int y1, int x2, int y2, int x3, int y3 , Node node, Node node2, Node node3){
        return isAvailableToRotate(x1,y1,node) && isAvailableToRotate(x2,y2, node2) && isAvailableToRotate(x3,y3,node3);
    }

    public boolean isAvailableToRotate(int x1, int y1, int x2, int y2, Node node, Node node2){
        return isAvailableToRotate(x1,y1,node) && isAvailableToRotate(x2,y2, node2);
    }

    public boolean isAvailableToRotate(int oldX, int oldY, Node node){

        int[][] gameBoard = CommandLine.getInstance().getGameBoard();

        int x = oldX + node.getPointOnBoardGame().getX();
        int y = oldY + node.getPointOnBoardGame().getY();

        if(y<=0 || y>=21 || x<=0 || x>=11){
            return false;
        }
        if(gameBoard[y][x] == 1){
            return false;
        }
        else{
            return true;
        }

    }

    public void goToFloor(){
        while(checkDownFloorIsFree()){
            goDown();
        }
    }


}
