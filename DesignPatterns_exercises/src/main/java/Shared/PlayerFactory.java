package Shared;

import Model.GameObject;
import Model.Initializer;
import Model.Player;

public class PlayerFactory implements Factory{

    @Override
    public GameObject produce() {
        int[] params = Initializer.dataStorage.load(Player.class);
        return new Player(params[0],params[1]);
    }
}
