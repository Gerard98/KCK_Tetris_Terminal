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


        switch (position){
            case 0:
                for(int i=1;i<4;i++){
                    Node node = getFigure().get(i);
                    Point pointBoard = node.getPointOnBoard();
                    Point pointGame = node.getPointOnBoardGame();

                    pointBoard.setY(pointBoard.getY()+i);
                    pointBoard.setX(pointBoard.getX()-i);

                    deleteNodeFromBoard(node);
                    pointGame.setY(pointGame.getY()+i);
                    pointGame.setX(pointGame.getX()-i*3);
                    printNodeToBoard(node);


                }
                position = 1;
                break;
            case 1:
                for(int i=1;i<4;i++){
                    Node node = getFigure().get(i);
                    Point pointBoard = node.getPointOnBoard();
                    Point pointGame = node.getPointOnBoardGame();

                    pointBoard.setY(pointBoard.getY()-i);
                    pointBoard.setX(pointBoard.getX()+i);

                    deleteNodeFromBoard(node);
                    pointGame.setY(pointGame.getY()-i);
                    pointGame.setX(pointGame.getX()+i*3);
                    printNodeToBoard(node);


                }
                position = 1;
                break;
        }
    }

}
