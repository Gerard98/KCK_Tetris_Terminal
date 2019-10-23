package Figures;
import Ogólnie.CommandLine;

public class Square extends Figure {

    private char[][] figure;

    public Square(){

        figure = new char[][]{  {'[','x',']','[','x',']'},
                                {'[','x',']','[','x',']'}  };

        setStartPosition();

    }

    public void setStartPosition(){

        for(int i=0;i<2;i++){
            for(int j=0;j<6;j++){
                CommandLine.getInstance().putChar(j+15,i+3,figure[i][j]);
            }
        }
    }

    public boolean checkDownFloorIsFree(){
        return true;
    }


}
