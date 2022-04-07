package Shared;

import Model.GameObject;
import Model.Stone;

public class StoneFactory implements Factory{
    @Override
    public GameObject produce() {
        return new Stone();
    }
}
