import Ogólnie.KeyListener;
import Ogólnie.Motion;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Motion motion = new Motion();
        KeyListener keyListener = new KeyListener();
        motion.start();
        keyListener.start();
    }

    public void chuj(){

    }

}
