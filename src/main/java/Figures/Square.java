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
                node.setPointOnBoardGame(i,j);
                node.setPointOnBoard(i*3+15, j+3);
                figure.add(node);
                printNodeToBoard(node);
            }
        }
    }


    public boolean checkDownFloorIsFree(){
        return true;
    }

    public void goDown(){
        figure.forEach(m -> {
            Point point = m.getPointOnBoard();
            deleteNodeFromBoard(m);
            point.setY(point.getY()+1);
            printNodeToBoard(m);

        });
    }


}
