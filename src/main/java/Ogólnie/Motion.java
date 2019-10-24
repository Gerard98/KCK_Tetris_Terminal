package Ogólnie;

import Figures.Figure;
import Figures.Square;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.concurrent.TimeUnit;

public class Motion extends Thread{


    private Boolean stop;

    @Override
    public void run() {

        while(true){

            CommandLine.getInstance().setFigure(new Square());
            Figure figure = CommandLine.getInstance().getFigure();
            stop = false;

            while(!stop){

                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException ex){ex.printStackTrace();}

                if(figure.checkDownFloorIsFree()) {
                    figure.goDown();
                }
                else{
                    figure.setNewGameBoardPoints();
                    stop = true;
                }
                CommandLine.getInstance().refresh();

            }


        }

    }

}
