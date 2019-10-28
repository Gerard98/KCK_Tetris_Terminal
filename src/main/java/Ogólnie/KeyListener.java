package Ogólnie;

import Figures.Figure;
import Figures.Square;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.concurrent.TimeUnit;

public class KeyListener extends Thread {

    private KeyStroke keyPressed;

    @Override
    public void run() {

        while(true) {
            keyPressed = CommandLine.getInstance().getKeyPressed();
            if(keyPressed != null) {
                Figure figure = CommandLine.getInstance().getFigure();
                switch (keyPressed.getKeyType()){
                    case ArrowRight:
                        figure.goRight();
                        break;
                    case ArrowLeft:
                        figure.goLeft();
                        break;
                    case ArrowUp:
                        figure.rotate();
                        break;
                }
            }
        }



    }


}
