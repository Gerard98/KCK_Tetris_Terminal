package Figures;

import Ogólnie.CommandLine;
import Positions.Point;

public abstract class Figure {

    public abstract void goDown();
    public abstract boolean checkDownFloorIsFree();

    public void printNodeToBoard(Node node){
        Point point = node.getPointOnBoard();
        for(int i=0;i<3;i++){
            CommandLine.getInstance().putChar(point.getX()+i,point.getY(),node.getBody(i));
        }
    }

    public void deleteNodeFromBoard(Node node){
        Point point = node.getPointOnBoard();
        for(int i=0;i<3;i++){
            CommandLine.getInstance().putChar(point.getX()+i,point.getY(),' ');
        }
    }


}
