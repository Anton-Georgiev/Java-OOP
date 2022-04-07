import Model.GameObject;
import Model.Initializer;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<GameObject> gameObjects = Initializer.init();

        boolean gameOver = false;

        while(!gameOver){
            for (GameObject gameObject : gameObjects) {
                gameObject.update();
                gameObject.draw();
            }
            Thread.sleep(2000);
        }

    }
}
