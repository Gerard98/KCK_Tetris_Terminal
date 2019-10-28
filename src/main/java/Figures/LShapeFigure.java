package Figures;

import Positions.Point;

public class LShapeFigure extends Figure {

    // That figure can have a 4 dirent positions
    /*

    0:      x         3
        x x x     0 1 2

    1:  x         3
        x         0
        x x       1 2

    2:  x x x     1 2 3
        x         0

    3:  x x       1 2
          x         3
          x         0

    */

    public int position = 0;

    @Override
    public void setPositionInQuene() {
        for(int i=0;i<3;i++){
            Node node = new Node();
            node.setPointOnBoardGame(5+i,2);
            node.setPointOnBoard(i*3+49, 17);

            addNode(node);
            printNodeToBoard(node);
        }

        Node node = new Node();
        node.setPointOnBoardGame(7,1);
        node.setPointOnBoard(2*3+49, 16);

        addNode(node);
        printNodeToBoard(node);

    }

    @Override
    public void setPositionToFall() {
        for(int i=0;i<3;i++){
            Node node = getFigure().get(i);
            deleteNodeFromBoard(node);
            node.setPointOnBoard(i*3+15, 4);
            printNodeToBoard(node);

        }

        Node node = getFigure().get(3);
        deleteNodeFromBoard(node);
        node.setPointOnBoard(2*3+15, 3);
        printNodeToBoard(node);

    }

    public void rotate(){

        Node node0 = getFigure().get(0);
        Node node3 = getFigure().get(3);

        switch (position){
            case 0:
                if(isAvailableToRotate(1,-1,-1,-1, node0, node3)) {
                    node0.relocateBothPoints(1, -1);
                    node3.relocateBothPoints(-1, -1);
                    position = 1;
                }
                break;

            case 1:
                if(isAvailableToRotate(0,2,2,2, node0, node3)) {
                    node0.relocateBothPoints(0, 2);
                    node3.relocateBothPoints(2, 2);
                    position = 2;
                }
                break;

            case 2:
                if(isAvailableToRotate(1,1,-1,1, node0, node3)) {
                    node0.relocateBothPoints(1, 1);
                    node3.relocateBothPoints(-1, 1);
                    position = 3;
                }
                break;

            case 3:
                if(isAvailableToRotate(-2,-2,0,-2, node0, node3)) {
                    node0.relocateBothPoints(-2, -2);
                    node3.relocateBothPoints(0, -2);
                    position = 0;
                }
                break;
        }
    }

    @Override
    public void goDown() {

        switch (position){
            case 0:
                super.goDown();
                break;
            case 1:
                goDownByTabInt(new int[] {1,2,0,3});
                break;
            case 2:
                super.goDown();
                break;
            case 3:
                goDownByTabInt(new int[] {0,3,2,1});
                break;

        }

    }

}
