package Shared;

import Model.GameObject;

import java.util.List;

public interface ProduceMultiple {
    List<GameObject> produce();

    void setFactories(List<Factory> objectFactory);
}
