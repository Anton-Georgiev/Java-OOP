package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GunRepository implements Repository<Gun> {
    private List<Gun> models = new ArrayList<>();

    @Override
    public List<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Gun model) {
       long num = models.stream().filter(e -> e.getName().equals(model.getName())).count();
       if (num < 1){
           models.add(model);
       }
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return models.stream().filter(e-> e.getName().equals(name)).findFirst().get();
    }
}