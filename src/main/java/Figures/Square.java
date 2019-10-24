package Figures;
import Ogólnie.CommandLine;
import Positions.Point;

import java.util.LinkedList;
import java.util.List;

public class Square extends Figure {

    private List<Node> figure;


    public Square(){

        for(int i=0;i<4;i++){
            figure = new LinkedList<>();
        }

        setStartPosition();

    }

    public void setStartPosition(){
        // Odwróciłem tutaj aby najpierw się dodały te niższe kwadraty by przy odczytywaniu z listy żeby
        // najpierw one spadały, bo jak były najpierw te górne to się nakładały na siebie i zostawała 1 linia tylko
        for(int i=0;i<2;i++){
            for(int j=1;j>=0;j--){
                Node node = new Node();
                node.setPointOnBoardGame(5+j,i+1);
                node.setPointOnBoard(i*3+15, j+3);
                figure.add(node);
                printNodeToBoard(node);
            }
        }
    }


    public boolean checkDownFloorIsFree(){
        boolean check =  figure.stream().anyMatch(m -> {
            boolean isThereNodeBelow = false;
            isThereNodeBelow = figure.stream().anyMatch(n -> n.getPointOnBoardGame().getY() == m.getPointOnBoardGame().getY()+1);
            if(!isThereNodeBelow){
                int[][] gameBoard = CommandLine.getInstance().getGameBoard();
                Point point = m.getPointOnBoardGame();
                return gameBoard[point.getY()+1][point.getX()] == 0;
            }
            else return false;
        });

        return check;
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

    public void goRight(){
        figure.forEach(m -> {
            Point pointOnBoard = m.getPointOnBoard();
            Point pointOnGameBoard = m.getPointOnBoardGame();
            deleteNodeFromBoard(m);
            pointOnGameBoard.setX(pointOnGameBoard.getX()+1);
            pointOnBoard.setX(pointOnBoard.getX()+3);
            printNodeToBoard(m);

        });
    }

    public void goLeft(){
        figure.forEach(m -> {
            Point pointOnBoard = m.getPointOnBoard();
            Point pointOnGameBoard = m.getPointOnBoardGame();
            deleteNodeFromBoard(m);
            pointOnGameBoard.setX(pointOnGameBoard.getX()-1);
            pointOnBoard.setX(pointOnBoard.getX()-3);
            printNodeToBoard(m);

        });
    }

    /**
     * Funkcja ustawia wartosci w tablicy gameBoard na 1 w miejsca gdzie spadla figura
     */

    public void setNewGameBoardPoints(){
        figure.forEach(m -> {
            Point point = m.getPointOnBoardGame();
            CommandLine.getInstance().changeValueOfGameBoard(point.getX(), point.getY(), 1);

        });
    }


}
