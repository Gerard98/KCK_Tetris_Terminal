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

                if(figure.checkDownFloorIsFree()){
                    figure.goDown();
                    try{
                        TimeUnit.SECONDS.sleep(5);
                    }catch (InterruptedException ex){ex.printStackTrace();}
                }
                else{
                    stop = true;
                }
                CommandLine.getInstance().refresh();




            }


        }

    }

}
