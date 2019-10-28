package Figures;

public class TShapeFigure extends Figure {

    // That figure can have a 4 dirent positions
    /*

    0:    x         3
        x x x     0 1 2

    1:  x         3
        x x       1 2
        x         0

    2:  x x x     0 3 2
          x         1

    3:    x         3
        x x       0 1
          x         2

    */

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
        node.setPointOnBoardGame(6,1);
        node.setPointOnBoard(1*3+49, 16);

        addNode(node);
        printNodeToBoard(node);

    }

    @Override
    public void setPositionToFall() {
        for(int i=0;i<3;i++){
            Node node = getFigure().get(i);
            //node.setPointOnBoardGame(5+i,1);
            node.setPointOnBoard(i*3+15, 4);
            printNodeToBoard(node);

        }

        Node node = getFigure().get(3);
        //node.setPointOnBoardGame(5+i,1);
        node.setPointOnBoard(1*3+15, 3);
        printNodeToBoard(node);

    }

    public void rotate(){

    }
}
