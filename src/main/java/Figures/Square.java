package Figures;
import Ogólnie.CommandLine;
import Positions.Point;

import java.util.LinkedList;
import java.util.List;

public class Square extends Figure {


    public Square(){
        super();
        // Odwróciłem tutaj aby najpierw się dodały te niższe kwadraty by przy odczytywaniu z listy żeby
        // najpierw one spadały, bo jak były najpierw te górne to się nakładały na siebie i zostawała 1 linia tylko
        for(int i=0;i<2;i++){
            for(int j=1;j>=0;j--){
                Node node = new Node();
                node.setPointOnBoardGame(5+j,i+1);
                node.setPointOnBoard(i*3+15, j+3);

                addNode(node);
                printNodeToBoard(node);
            }
        }

        setStartPosition();

    }

    public void setStartPosition(){
        /**
         *
         *
         *
         */
    }






    /**
     * Funkcja ustawia wartosci w tablicy gameBoard na 1 w miejsca gdzie spadla figura
     */

    public void setNewGameBoardPoints(){
        getFigure().forEach(m -> {
            Point point = m.getPointOnBoardGame();
            CommandLine.getInstance().changeValueOfGameBoard(point.getX(), point.getY(), 1);

        });
    }


}
