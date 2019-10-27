package Figures;

import Ogólnie.CommandLine;
import Positions.Point;

import java.util.LinkedList;
import java.util.List;

public abstract class Figure {

    private List<Node> figure;

    public abstract void setNewGameBoardPoints();

    public Figure(){
        figure = new LinkedList<>();
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

}
