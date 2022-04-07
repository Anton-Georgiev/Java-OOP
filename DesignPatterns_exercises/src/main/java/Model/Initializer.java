package Model;

import Data.DataStorage;
import Model.GameObject;
import Shared.*;

import java.util.ArrayList;
import java.util.List;

public class    Initializer {
    public static DataStorage dataStorage = new DataStorage();
    public static ProduceMultiple multiple = new InitialGameObjects();
    public static List<Factory> objectFactory = new ArrayList<>();

    public static List<GameObject> init(){
        objectFactory.add(new PlayerFactory());
        objectFactory.add(new EnemyFactory());
        multiple.setFactories(objectFactory);

        return multiple.produce();
    }
}
