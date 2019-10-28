package Ogólnie;

import Figures.*;

import java.util.Random;

public class RandomFigure {

    public static Figure getRandomFigure(){
        Random random = new Random();
        int a = random.nextInt(7);
        switch (a){
            case 0:
                return new ZShapeFigure();
            case 1:
                return new InvertedZShape();
            case 2:
                return new TShapeFigure();
            case 3:
                return new LShapeFigure();
            case 4:
                return new InvertedLShape();
            case 5:
                return new Square();
            case 6:
                return new Lane();
            default:
                return new Square();
        }
    }


}
