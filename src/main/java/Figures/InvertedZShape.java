package Figures;

public class InvertedZShape extends Figure {

    // That figure can have a 2 dirent positions
    /*

    0:    x x       0 1
        x x       2 3

    1:  x         0
        x x       3 1
          x         2

    */

    @Override
    public void setPositionInQuene() {

        for(int i=0;i<2;i++){
            Node node = new Node();
            node.setPointOnBoardGame(5+i,2);
            node.setPointOnBoard(i*3+49, 17);

            addNode(node);
            printNodeToBoard(node);
        }

        for(int i=0;i<2;i++){
            Node node = new Node();
            node.setPointOnBoardGame(6+i,1);
            node.setPointOnBoard(i*3+52, 16);

            addNode(node);
            printNodeToBoard(node);
        }

    }

    @Override
    public void setPositionToFall() {

        for(int i=0;i<2;i++){
            Node node = getFigure().get(i);
            node.setPointOnBoard(i*3+15, 4);

            printNodeToBoard(node);
        }

        for(int i=0;i<2;i++){
            Node node = getFigure().get(i+2);
            node.setPointOnBoard(i*3+18, 3);

            printNodeToBoard(node);
        }

    }

    public void rotate(){

    }
}
