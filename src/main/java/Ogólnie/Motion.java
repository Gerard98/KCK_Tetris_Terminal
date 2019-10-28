package Ogólnie;

import Figures.Figure;
import Figures.Square;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.concurrent.TimeUnit;

public class Motion extends Thread{


    private Boolean stop;

    @Override
    public void run() {

        CommandLine.getInstance().setFirstQuene();
        CommandLine.getInstance().addNewFigure();

        while(true){

            Figure figure = CommandLine.getInstance().getFigure();
            stop = false;

            while(!stop){

                try{
                    TimeUnit.MILLISECONDS.sleep(1000);
                    //TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException ex){ex.printStackTrace();}

                if(figure.checkDownFloorIsFree()) {
                    figure.goDown();
                }
                else{
                    figure.setNewGameBoardPoints();
                    CommandLine.getInstance().checkForDeleteLane();
                    //CommandLine.getInstance().setFigure(new Square());
                    CommandLine.getInstance().addNewFigure();
                    stop = true;
                }
                CommandLine.getInstance().refresh();



            }
            CommandLine.getInstance().printGameBoard();
        }

    }

}
