package Shared;

import Model.GameObject;

import java.util.ArrayList;
import java.util.List;

public class InitialGameObjects implements ProduceMultiple {
    private List<Factory> objectFactories;

    public InitialGameObjects(){
        this.objectFactories = new ArrayList<>();
    }

    @Override
    public List<GameObject> produce() {
        List<GameObject> gameObjects = new ArrayList<>();
        for (Factory objectFactory : objectFactories) {
            gameObjects.add(objectFactory.produce());
        }
        return gameObjects;
    }

    @Override
    public void setFactories(List<Factory> objectFactories) {
        this.objectFactories = objectFactories;
    }
}
