package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.BaseFish;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ConstantMessages.WATER_NOT_SUITABLE;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity){
        setName(name);
        this.capacity = capacity;
        decorations = new ArrayList<>();
        fish = new ArrayList<>();
    }

    private void setName(String name){
        if (name == null || name.isEmpty()){
            throw new NullPointerException();
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        int result = 0;
        for (Decoration decoration : decorations) {
           result += decoration.getComfort();
        }
        return result;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if (capacity == this.fish.size()){
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        String clazz = this.getClass().getSimpleName().toString().replace("Aquarium", "");
        String fishName = fish.getClass().getSimpleName().toString().replace("Fish", "");
        if (!clazz.equals(fishName)){
            throw new IllegalArgumentException(WATER_NOT_SUITABLE);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish1 : fish) {
            fish1.eat();
        }
    }

    @Override
    public String getInfo() {

            StringBuilder builder = new StringBuilder();
            StringBuilder fishOutput = new StringBuilder();
            fishOutput.append("Fish: ");
        for (Fish fish1 : fish) {
            fishOutput.append(fish1.getName() + " ");
        }
        String fishOut = fishOutput.toString().trim();

        builder.append(this.getName() + " (" + this.getClass().getSimpleName() + "):").append(System.lineSeparator());

        if (this.fish.isEmpty()){
            return "none";
        } else{
            builder.append(fishOut);
            builder.append(System.lineSeparator());
            builder.append("Decorations: ").append(decorations.size()).append(System.lineSeparator());
            builder.append("Comfort: ").append(calculateComfort());
        }
        return builder.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
