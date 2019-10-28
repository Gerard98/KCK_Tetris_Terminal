package Figures;

import Positions.Point;

public class ZShapeFigure extends Figure{

    // That figure can have a 2 dirent positions
    /*

    0:  x x       0 1
          x x       2 3

    1:    x         1
        x x       0 2
        x         3

    */

    public int position = 0;

    @Override
    public void setPositionInQuene() {

        for(int i=0;i<2;i++){
            Node node = new Node();
            node.setPointOnBoardGame(5+i,1);
            node.setPointOnBoard(i*3+49, 16);

            addNode(node);
            printNodeToBoard(node);
        }

        for(int i=0;i<2;i++){
            Node node = new Node();
            node.setPointOnBoardGame(6+i,2);
            node.setPointOnBoard(i*3+52, 17);

            addNode(node);
            printNodeToBoard(node);
        }

    }

    @Override
    public void setPositionToFall() {

        for(int i=0;i<2;i++){
            Node node = getFigure().get(i);
            deleteNodeFromBoard(node);
            node.setPointOnBoard(i*3+15, 3);
            printNodeToBoard(node);
        }

        for(int i=0;i<2;i++){
            Node node = getFigure().get(i+2);
            deleteNodeFromBoard(node);
            node.setPointOnBoard(i*3+18, 4);
            printNodeToBoard(node);
        }

    }

    public void rotate(){
        Node node0 = getFigure().get(0);
        Node node3 = getFigure().get(3);

        switch (position){
            case 0:
                if(isAvailableToRotate(0,1,-2,1, node0, node3)) {
                    node0.relocateBothPoints(0, 1);
                    node3.relocateBothPoints(-2, 1);
                    position = 1;
                }
                break;

            case 1:
                if(isAvailableToRotate(0,-1,2,-1, node0, node3)) {
                    node0.relocateBothPoints(0, -1);
                    node3.relocateBothPoints(2, -1);
                    position = 0;
                }
                break;
        }
    }

    @Override
    public void goDown() {

        switch (position){
            case 0:
                goDownByTabInt(new int[] {3,2,1,0});
                break;
            case 1:
                goDownByTabInt(new int[] {3,0,2,1});
                break;
        }

    }
}
