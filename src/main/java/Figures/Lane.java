package Figures;

import Positions.Point;

public class Lane extends Figure {

    // That figure can have a 2 dirent positions
    /*

    0:  x x x x     0 1 2 3

    1:  x           0
        x           1
        x           2
        x           3

    */

    private int position = 0;

    @Override
    public void setPositionToFall() {
        for(int i=0;i<4;i++){
            Node node = getFigure().get(i);
            deleteNodeFromBoard(node);
            node.setPointOnBoardGame(5+i,1);
            node.setPointOnBoard(i*3+15, 3);
            printNodeToBoard(node);

        }
    }

    @Override
    public void setPositionInQuene() {

        for(int i=0;i<4;i++){
                Node node = new Node();
                node.setPointOnBoardGame(5+i,1);
                node.setPointOnBoard(i*3+46, 16);

                addNode(node);
                printNodeToBoard(node);

        }
    }

    public void rotate(){

        Node node1 = getFigure().get(1);
        Node node2 = getFigure().get(2);
        Node node3 = getFigure().get(3);


        switch (position){
            case 0:

                if(isAvailableToRotate(-1,1,-2,2,-3,3,node1,node2,node3)){
                    node1.relocateBothPoints(-1,1);
                    node2.relocateBothPoints(-2,2);
                    node3.relocateBothPoints(-3,3);
                    position = 1;
                }

                break;
            case 1:
                if(isAvailableToRotate(1,-1,2,-2,3,-3,node1,node2,node3)){
                    node1.relocateBothPoints(1,-1);
                    node2.relocateBothPoints(2,-2);
                    node3.relocateBothPoints(3,-3);
                    position = 1;
                }
                break;
        }
    }

    @Override
    public void goDown(){
        goDownByTabInt(new int[] {3,2,1,0});
    }

}
