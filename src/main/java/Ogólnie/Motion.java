package Ogólnie;

import Figures.Figure;
import Figures.Square;

import java.util.concurrent.TimeUnit;

public class Motion implements Runnable{

    private Figure figure;
    private Boolean stop;

    @Override
    public void run() {

        while(true){

            figure = new Square();
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
