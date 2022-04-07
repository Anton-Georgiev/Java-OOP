package Shared;

import Model.Enemy;
import Model.GameObject;
import Model.Initializer;
import Model.Player;

public class EnemyFactory implements Factory{
    @Override
    public GameObject produce() {
        int[] params = Initializer.dataStorage.load(Enemy.class);
        return new Enemy(params[0], params[1]);
    }
}
