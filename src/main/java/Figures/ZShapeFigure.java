package Figures;

import Positions.Point;

public class ZShapeFigure extends Figure{

    // That figure can have a 2 dirent positions
    /*

    0:  x x      2 3
          x x      0 1

    1:    x         1
        x x       3 2
        x         0

    */

    public int position = 0;

    @Override
    public void setPositionInQuene() {

        for(int i=0;i<2;i++){
            Node node = new Node();
            node.setPointOnBoardGame(6+i,2);
            node.setPointOnBoard(i*3+52, 17);

            addNode(node);
            printNodeToBoard(node);
        }

        for(int i=0;i<2;i++){
            Node node = new Node();
            node.setPointOnBoardGame(5+i,1);
            node.setPointOnBoard(i*3+49, 16);

            addNode(node);
            printNodeToBoard(node);
        }

    }

    @Override
    public void setPositionToFall() {

        for(int i=0;i<2;i++){
            Node node = getFigure().get(i);
            node.setPointOnBoard(i*3+18, 4);

            printNodeToBoard(node);
        }

        for(int i=0;i<2;i++){
            Node node = getFigure().get(i+2);
            node.setPointOnBoard(i*3+15, 3);

            printNodeToBoard(node);
        }

    }

    public void rotate(){
        Node node1 = getFigure().get(1);
        Node node2 = getFigure().get(2);

        switch (position){
            case 0:

                node1.getPointOnBoardGame().setY(node1.getPointOnBoardGame().getY() -2);
                node2.getPointOnBoardGame().setX(node2.getPointOnBoardGame().getX() +2);

                deleteNodeFromBoard(node1);
                node1.getPointOnBoard().setY(node1.getPointOnBoard().getY() -2);
                printNodeToBoard(node1);
                deleteNodeFromBoard(node2);
                node2.getPointOnBoard().setX(node1.getPointOnBoard().getX() +6);
                printNodeToBoard(node2);

                position = 1;
                break;

            case 1:

                node1.getPointOnBoardGame().setY(node1.getPointOnBoardGame().getY() +2);
                node2.getPointOnBoardGame().setX(node2.getPointOnBoardGame().getX() -2);

                deleteNodeFromBoard(node1);
                node1.getPointOnBoard().setY(node1.getPointOnBoard().getY() +2);
                printNodeToBoard(node1);
                deleteNodeFromBoard(node2);
                node2.getPointOnBoard().setX(node1.getPointOnBoard().getX() -6);
                printNodeToBoard(node2);

                position = 0;
                break;
        }
    }


}
