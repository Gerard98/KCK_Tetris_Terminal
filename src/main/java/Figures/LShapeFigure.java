package Figures;

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
            node.setPointOnBoard(i*3+15, 4);
            printNodeToBoard(node);

        }

        Node node = getFigure().get(3);

        node.setPointOnBoard(2*3+15, 3);
        printNodeToBoard(node);

    }

    public void rotate(){

    }

}
