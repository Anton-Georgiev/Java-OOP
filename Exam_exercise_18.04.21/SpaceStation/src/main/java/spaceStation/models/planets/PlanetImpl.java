package spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static spaceStation.common.ExceptionMessages.*;

public class PlanetImpl implements Planet{
    private String name;
    private List<String> items;

    public PlanetImpl(String name){
        setName(name);
        items = new ArrayList<>();
    }
    @Override
    public Collection<String> getItems() {
        return this.items;
    }
    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.equals("\\s+")){
            throw new NullPointerException(PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
