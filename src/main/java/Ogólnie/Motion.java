package Ogólnie;

import Figures.Figure;
import Figures.Square;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.concurrent.TimeUnit;

public class Motion extends Thread{


    private boolean stop;
    private boolean endGame;

    @Override
    public void run() {

        CommandLine.getInstance().setFirstQuene();
        CommandLine.getInstance().addNewFigure();
        endGame = false;
        while(!endGame){

            Figure figure = CommandLine.getInstance().getFigure();
            stop = false;

            while(!stop){

                try{
                    //TimeUnit.MILLISECONDS.sleep(1050 - CommandLine.getInstance().getLevel()*50);
                    TimeUnit.MILLISECONDS.sleep(100);
                }catch (InterruptedException ex){ex.printStackTrace();}

                if(figure.checkDownFloorIsFree()) {
                    figure.goDown();
                }
                else{
                    figure.setNewGameBoardPoints();
                    CommandLine.getInstance().checkForDeleteLane();
                    stop = true;
                    if(!figure.checkForEndGame()) {
                        CommandLine.getInstance().addNewFigure();
                    }
                    else {
                        endGame = true;
                        CommandLine.getInstance().printEndScreen();
                    }
                }
                CommandLine.getInstance().refresh();

            }
            CommandLine.getInstance().printGameBoard();
        }

    }

}
