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
    private int position = 0;

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
            deleteNodeFromBoard(node);
            node.setPointOnBoard(i*3+15, 4);
            printNodeToBoard(node);

        }

        Node node = getFigure().get(3);
        deleteNodeFromBoard(node);
        node.setPointOnBoard(1*3+15, 3);
        printNodeToBoard(node);

    }

    public void rotate(){

        Node node0 = getFigure().get(0);
        Node node2 = getFigure().get(2);

        switch (position){
            case 0:
                if(isAvailableToRotate(1,1, node0)) {
                    node0.relocateBothPoints(1, 1);
                    position = 1;
                }
                break;

            case 1:
                if(isAvailableToRotate(-1,-2,0,-1, node0, node2)) {
                    node0.relocateBothPoints(-1, -2);
                    node2.relocateBothPoints(0, -1);
                    position = 2;
                }
                break;

            case 2:
                if(isAvailableToRotate(0,1,-1,2, node0, node2)) {
                    node0.relocateBothPoints(0, 1);
                    node2.relocateBothPoints(-1, 2);
                    position = 3;
                }
                break;

            case 3:
                if(isAvailableToRotate(1,-1, node2)) {
                    node2.relocateBothPoints(1, -1);
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
                super.goDown();
                break;
            case 2:
                super.goDown();
                break;
            case 3:
                goDownByTabInt(new int[] {2,1,0,3});
                break;

        }

    }


}
