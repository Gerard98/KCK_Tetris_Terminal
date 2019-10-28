import Ogólnie.KeyListener;
import Ogólnie.Motion;


public class Main {

    public static void main(String[] args){
        Motion motion = new Motion();
        KeyListener keyListener = new KeyListener();
        motion.start(keyListener);
        keyListener.start();
    }


}
