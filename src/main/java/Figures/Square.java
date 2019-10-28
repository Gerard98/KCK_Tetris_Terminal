package Figures;
import Ogólnie.CommandLine;
import Positions.Point;

import java.util.LinkedList;
import java.util.List;

public class Square extends Figure {

    @Override
    public void setPositionToFall() {
        int k = 0;
        for(int i=0;i<2;i++){
            for(int j=1;j>=0;j--){
                Node node = getFigure().get(k);

                deleteNodeFromBoard(node);

                node.setPointOnBoardGame(5+j,i+1);
                node.setPointOnBoard(i*3+15, j+3);

                printNodeToBoard(node);
                k++;
            }
        }
    }

    @Override
    public void setPositionInQuene() {

        for(int i=0;i<2;i++){
            for(int j=1;j>=0;j--){
                Node node = new Node();
                node.setPointOnBoardGame(5+j,i+1);
                node.setPointOnBoard(i*3+49, 16+j);

                addNode(node);
                printNodeToBoard(node);
            }
        }



    }

    public void rotate(){

    }


}
